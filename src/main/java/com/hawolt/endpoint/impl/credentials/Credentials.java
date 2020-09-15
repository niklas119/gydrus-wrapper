package com.hawolt.endpoint.impl.credentials;

import com.hawolt.*;
import com.hawolt.dispatcher.DispatchQueue;
import com.hawolt.dispatcher.DispatchStatusCallback;
import com.hawolt.dispatcher.impl.DeleteAccountDispatch;
import com.hawolt.dispatcher.impl.RestartAccountVMDispatch;
import com.hawolt.endpoint.Tab;
import com.hawolt.endpoint.impl.dashboard.DashboardAccount;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class Credentials extends Tab implements Iterable<AccountInfo> {
    private Map<String,AccountInfo> info = new HashMap<>();

    public Credentials(String resource) throws IOException, InitializationException {
        super(resource);
        JSONObject response = new JSONObject(this.response);
        JSONArray data = response.getJSONArray("data");
        for (int i = 0; i < data.length(); i++) {
            AccountInfo accountInfo = new AccountInfo(data.getJSONObject(i));
            info.put(accountInfo.getId(),accountInfo);
        }
    }

    @Override
    public String fetch(boolean ignore) throws IOException, InitializationException {
        Request request = new Request(resource, Method.POST, true);
        request.addHeader("content-Type", "application/json");
        request.addHeader("authorization", String.format("Bearer %s", TokenManager.getToken(ignore)));
        request.write(String.format("{\"password\":\"%s\"}", TokenManager.password));
        Response response = new Response(request);
        if (response.getCode() != 200) return fetch(true);
        return response.getBody();
    }

    @Override
    public Iterator<AccountInfo> iterator() {
        return info.values().iterator();
    }

    public List<AccountInfo> getInfo() {
        return new ArrayList<>(info.values());
    }

    public AccountInfo find(String id){
        return info.get(id);
    }

    public static void delete(DispatchStatusCallback callback,String id)  {
        DispatchQueue.submit(new DeleteAccountDispatch(callback,id));
    }
}
