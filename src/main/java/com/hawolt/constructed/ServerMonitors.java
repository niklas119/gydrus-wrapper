package com.hawolt.constructed;

import com.hawolt.endpoint.impl.dashboard.Dashboard;
import com.hawolt.endpoint.impl.dashboard.DashboardAccount;

import java.util.*;

public class ServerMonitors implements Iterable<ServerMonitor> {
    private List<ServerMonitor> monitors = new ArrayList<>();

    public ServerMonitors(Dashboard dashboard) {
        Map<String, List<DashboardAccount>> map = new HashMap<>();
        for (DashboardAccount account : dashboard) {
            if (account.getIp().equals("-")) continue;
            if (!map.containsKey(account.getIp())) map.put(account.getIp(), new ArrayList<>());
            map.get(account.getIp()).add(account);
        }
        for (String key : map.keySet()) {
            monitors.add(new ServerMonitor(key, map.get(key)));
        }
    }

    @Override
    public Iterator<ServerMonitor> iterator() {
        return monitors.iterator();
    }

    public List<ServerMonitor> getMonitors() {
        return monitors;
    }
}
