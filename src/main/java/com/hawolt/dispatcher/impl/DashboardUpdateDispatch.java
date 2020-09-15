package com.hawolt.dispatcher.impl;

import com.hawolt.*;
import com.hawolt.dispatcher.DispatchEvent;
import com.hawolt.dispatcher.DispatchStatusCallback;
import com.hawolt.dispatcher.Patch;
import com.hawolt.endpoint.impl.dashboard.DashboardAccountEditor;
import com.hawolt.endpoint.impl.dashboard.DashboardBulkAccountEditor;
import org.json.JSONObject;

import java.io.IOException;

public class DashboardUpdateDispatch extends Patch {
    private JSONObject object;

    public DashboardUpdateDispatch(DispatchStatusCallback callback, DashboardAccountEditor editor) {
        super(callback);
        this.object = editor.getFinalized();
    }

    public DashboardUpdateDispatch(DispatchStatusCallback callback, JSONObject object) {
        super(callback);
        this.object = object;
    }

    @Override
    public void run() {
        try {
            Request request = new Request("https://gydrus.net/api/v1/accounts", Method.PUT, true);
            request.addHeader("connection", "keep-alive");
            request.addHeader("origin", "https://gydrus.net");
            request.addHeader("referer", "https://gydrus.net/dashboard");
            request.addHeader("content-Type", "application/json");
            request.addHeader("authorization", String.format("Bearer %s", TokenManager.getToken()));
            request.addHeader("content-length", String.valueOf(object.toString().length()));
            request.write(object.toString());
            Response response = new Response(request);
            callback.onCompletion(response.getCode(), response.getBody(), DispatchEvent.UPDATE_ACCOUNT, object);
        } catch (IOException | InitializationException e) {
            callback.onException(e, DispatchEvent.UPDATE_ACCOUNT, object);
        }
    }
}
