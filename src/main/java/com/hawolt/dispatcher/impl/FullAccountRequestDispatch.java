package com.hawolt.dispatcher.impl;

import com.hawolt.*;
import com.hawolt.dispatcher.DispatchEvent;
import com.hawolt.dispatcher.DispatchStatusCallback;
import com.hawolt.dispatcher.Patch;
import org.json.JSONObject;

import java.io.IOException;

public class FullAccountRequestDispatch extends Patch {
    private String id;

    public FullAccountRequestDispatch(DispatchStatusCallback callback, String id) {
        super(callback);
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(String.format("https://gydrus.net/api/v1/accounts/%s/full", id), Method.GET, false);
            request.addHeader("connection", "keep-alive");
            request.addHeader("origin", "https://gydrus.net");
            request.addHeader("referer", "https://gydrus.net/dashboard");
            request.addHeader("authorization", String.format("Bearer %s", TokenManager.getToken()));
            Response response = new Response(request);
            callback.onCompletion(response.getCode(), response.getBody(), DispatchEvent.REQUEST_FULL_ACCOUNT, new JSONObject(response.getBody()));
        } catch (IOException | InitializationException e) {
            callback.onException(e, DispatchEvent.REQUEST_FULL_ACCOUNT, id);
        }
    }
}
