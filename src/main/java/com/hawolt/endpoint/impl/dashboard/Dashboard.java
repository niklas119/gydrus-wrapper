package com.hawolt.endpoint.impl.dashboard;

import com.hawolt.*;
import com.hawolt.dispatcher.DispatchQueue;
import com.hawolt.dispatcher.DispatchStatusCallback;
import com.hawolt.dispatcher.impl.*;
import com.hawolt.endpoint.Tab;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dashboard extends Tab implements Iterable<DashboardAccount> {

    private List<DashboardAccount> accounts = new ArrayList<DashboardAccount>();

    public Dashboard(String resource) throws IOException, InitializationException {
        super(resource);
        JSONObject response = new JSONObject(this.response);
        JSONArray data = response.getJSONArray("data");
        for (int i = 0; i < data.length(); i++) {
            accounts.add(new DashboardAccount(data.getJSONObject(i)));
        }
    }

    public Iterator<DashboardAccount> iterator() {
        return accounts.iterator();
    }

    public List<DashboardAccount> getAccounts() {
        return accounts;
    }

    public static void request(DispatchStatusCallback callback, String id) {
        DispatchQueue.submit(new FullAccountRequestDispatch(callback, id));
    }

    public static void restart(DispatchStatusCallback callback, String id) {
        DispatchQueue.submit(new RestartAccountVMDispatch(callback, id));
    }

    public static void update(DispatchStatusCallback callback, DashboardBulkAccountEditor editor) {
        DispatchQueue.submit(new DashboardBulkUpdateDispatch(callback, editor));
    }

    public static void update(DispatchStatusCallback callback, JSONObject editor) {
        DispatchQueue.submit(new DashboardBulkUpdateDispatch(callback, editor));
    }

    public static void update(DispatchStatusCallback callback, DashboardAccountEditor editor) {
        DispatchQueue.submit(new DashboardUpdateDispatch(callback, editor));
    }

    public static void add(DispatchStatusCallback callback, DashboardAccountAddition editor) {
        DispatchQueue.submit(new DashboardAddDispatch(callback, editor));
    }

    public static void add(DispatchStatusCallback callback, JSONObject editor) {
        DispatchQueue.submit(new DashboardAddDispatch(callback, editor));
    }
}
