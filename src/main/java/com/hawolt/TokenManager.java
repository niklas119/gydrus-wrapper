package com.hawolt;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TokenManager {
    public static String username, password;
    public static JSONObject info;

    private static long last_cache;

    public static void init(String username, String password) throws IOException {
        TokenManager.username = username;
        TokenManager.password = password;
        try {
            String response = TokenManager.getInfo();
            int index = response.indexOf("Your IP");
            if (index == -1) {
                TokenManager.info = new JSONObject(TokenManager.getInfo());
            } else {
                int html = response.indexOf("<", index + 8);
                throw new InitializationException(String.format("IP %s not whitelisted", response.substring(index + 16, html)));
            }
        } catch (InitializationException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public static String getInfo() throws IOException, InitializationException {
        if (username == null || password == null) throw new InitializationException("TokenManger was not initialized");
        return getInfo(false);
    }


    public static String getToken(boolean ignore) throws IOException, InitializationException {
        if (username == null || password == null) throw new InitializationException("TokenManger was not initialized");
        TokenManager.info = new JSONObject(TokenManager.getInfo(ignore));
        return info.getString("token");
    }

    public static String getToken() throws IOException, InitializationException {
        if (username == null || password == null) throw new InitializationException("TokenManger was not initialized");
        if ((System.currentTimeMillis() - last_cache) >= TimeUnit.DAYS.toMillis(28)) {
            TokenManager.last_cache = System.currentTimeMillis();
            return getToken(true);
        }
        return getToken(false);
    }

    public static String getInfo(boolean ignore) throws IOException, InitializationException {
        if (username == null || password == null) throw new InitializationException("TokenManger was not initialized");
        Request request = new Request("https://gydrus.net/api/v1/auth/login", Method.POST, true);
        request.addHeader("content-Type", "application/json");
        request.write(String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password));
        Response response = new Response(request);
        return response.getBody();
    }

    public static void update() throws IOException, InitializationException {
        getToken(true);
    }
}
