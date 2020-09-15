# gydrus-wrapper

Usage examples

```java
import com.hawolt.Gydrus;
import com.hawolt.InitializationException;
import com.hawolt.constructed.ServerMonitor;
import com.hawolt.constructed.ServerMonitors;
import com.hawolt.dispatcher.AbstractCallback;
import com.hawolt.endpoint.impl.credentials.AccountInfo;
import com.hawolt.endpoint.impl.credentials.Credentials;
import com.hawolt.endpoint.impl.dashboard.*;
import com.hawolt.endpoint.impl.history.HistoryEntry;
import com.hawolt.endpoint.impl.history.HistoryModification;
import com.hawolt.endpoint.impl.whitelist.WhitelistEntry;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, InitializationException {
        Gydrus gydrus = new Gydrus("username", "password");

        for (HistoryEntry entry : gydrus.getHistory()) {
            System.out.format("%-24s at %s\n", entry.getDate(), entry.getTitle());
            for (HistoryModification modification : entry.getHistoryModifications()) {
                System.out.format("\t%4s %s\n", modification.getRegion().toUpperCase(), modification.getName());
            }
        }

        for (WhitelistEntry entry : gydrus.getWhitelist()) {
            System.out.format("%-15s created at %s for %s\n", entry.getIp(), entry.getDate(), entry.getOwnerName());
        }

        ServerMonitors monitors = gydrus.getMonitors();
        for (ServerMonitor monitor : monitors) {
            System.out.format("%-15s running %-2s accounts\n", monitor.getIp(), monitor.getActive());
        }

        Credentials credentials = gydrus.getCredentials();
        System.out.format("Added accounts: %s\n", credentials.getInfo().size());

        Dashboard dashboard = gydrus.getDashboard();
        List<DashboardAccount> list = dashboard.getAccounts().stream()
                .filter(account -> account.getStatus().equalsIgnoreCase("quota-finished"))
                .collect(Collectors.toList());

        for (DashboardAccount account : list) {
            AccountInfo info = credentials.find(account.getId());
            System.out.format("%s:%s:%s\n", info.getRegion(), info.getUsername(), info.getPassword());
        }

        AbstractCallback callback = new AbstractCallback() {
            @Override
            protected void onAccountAddition(Object... objects) {
                System.out.println("Successfully added account");
            }

            @Override
            protected void onAccountUpdate(Object... objects) {
                System.out.println("Update successful");
            }

            @Override
            protected void onAccountDeletion(Object... objects) {
                System.out.format("Account %s deleted\n", objects[0]);
            }

            @Override
            protected void onVMRestart(Object... objects) {
                System.out.format("Restart for %s submitted\n", objects[0]);
            }

            @Override
            protected void onFullAccountRequest(Object... objects) {
                FullDashboardAccount account = new FullDashboardAccount((JSONObject) objects[0]);
            }
        };

        DashboardAccount[] array = dashboard.getAccounts().stream()
                .filter(account -> account.getStatus().equalsIgnoreCase("quota-finished"))
                .toArray(DashboardAccount[]::new);
        DashboardBulkAccountEditor bulkAccountEditor = new DashboardBulkAccountEditor(array);
        bulkAccountEditor.setPriority(10);
        Dashboard.update(callback, bulkAccountEditor);

        ServerMonitor monitor = monitors.getMonitors().get(0);
        DashboardAccount account = monitor.getAccounts().get(0);
        Dashboard.restart(callback, account.getId());

        Dashboard.request(callback, account.getId());

        DashboardAccountEditor editor = new DashboardAccountEditor(account);
        editor.setDesiredLevel(40);
        editor.setPriority(3);
        Dashboard.update(callback, editor);

        DashboardAccountInfo info1 = new DashboardAccountInfo("region", "username", "password");
        DashboardAccountInfo info2 = new DashboardAccountInfo("region", "username", "password");
        DashboardAccountAddition addition = new DashboardAccountAddition(info1, info2);
        Dashboard.add(callback, addition);
    }
}
```
