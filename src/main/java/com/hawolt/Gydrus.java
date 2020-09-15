package com.hawolt;

import com.hawolt.constructed.ServerMonitors;
import com.hawolt.endpoint.impl.credentials.Credentials;
import com.hawolt.endpoint.impl.dashboard.*;
import com.hawolt.endpoint.impl.history.History;
import com.hawolt.endpoint.impl.whitelist.Whitelist;
import org.pmw.tinylog.Logger;

import java.io.IOException;

public class Gydrus {

    public Gydrus(String username, String password) {
        try {
            TokenManager.init(username, password);
        } catch (IOException e) {
            Logger.error(e);
        }
    }

    public Dashboard getDashboard() throws IOException, InitializationException {
        return new Dashboard("https://gydrus.net/api/v1/accounts");
    }

    public History getHistory() throws IOException, InitializationException {
        return new History("https://gydrus.net/api/v1/users/history/all");
    }

    public ServerMonitors getMonitors() throws IOException, InitializationException {
        return new ServerMonitors(getDashboard());
    }

    public Credentials getCredentials() throws IOException, InitializationException {
        return new Credentials("https://gydrus.net/api/v1/accounts/credentials");
    }

    public Whitelist getWhitelist() throws IOException, InitializationException {
        return new Whitelist("https://gydrus.net/api/v1/users/whitelisted-ips");
    }
}
