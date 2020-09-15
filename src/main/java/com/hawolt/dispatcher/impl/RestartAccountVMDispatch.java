package com.hawolt.dispatcher.impl;

import com.hawolt.*;
import com.hawolt.dispatcher.DispatchEvent;
import com.hawolt.dispatcher.DispatchStatusCallback;
import com.hawolt.dispatcher.Patch;

import java.io.IOException;

public class RestartAccountVMDispatch extends Patch {
    private String id;

    public RestartAccountVMDispatch(DispatchStatusCallback callback, String id) {
        super(callback);
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Request request = new Request("https://gydrus.net/api/v1/accounts/restart-vm", Method.PUT, true);
            request.addHeader("content-Type", "application/json");
            request.addHeader("authorization", String.format("Bearer %s", TokenManager.getToken(false)));
            request.write(String.format("[\"%s\"]", id));
            Response response = new Response(request);
            callback.onCompletion(response.getCode(), response.getBody(), DispatchEvent.RESTART_VM, id);
        } catch (IOException | InitializationException e) {
            callback.onException(e, DispatchEvent.RESTART_VM, id);
        }
    }
}
