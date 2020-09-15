package com.hawolt.endpoint;

import com.hawolt.InitializationException;
import com.hawolt.Request;
import com.hawolt.Response;
import com.hawolt.TokenManager;

import java.io.IOException;

public abstract class Tab {
    protected String resource, response;

    public Tab(String resource) throws IOException, InitializationException {
        this.resource = resource;
        this.response = this.fetch();
    }

    public String fetch() throws IOException, InitializationException {
        return fetch(false);
    }

    public String fetch(boolean ignore) throws IOException, InitializationException {
        Request request = new Request(resource);
        request.addHeader("content-Type", "application/json");
        request.addHeader("authorization", String.format("Bearer %s", TokenManager.getToken(ignore)));
        Response response = new Response(request);
        if (response.getCode() != 200) return fetch(true);
        return response.getBody();
    }
}
