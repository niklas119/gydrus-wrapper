package com.hawolt.constructed;

import com.hawolt.endpoint.impl.dashboard.DashboardAccount;

import java.util.Iterator;
import java.util.List;

public class ServerMonitor implements Iterable<DashboardAccount> {
    private List<DashboardAccount> accounts;
    private String ip;

    public ServerMonitor(String ip, List<DashboardAccount> accounts) {
        this.ip = ip;
        this.accounts = accounts;
    }

    @Override
    public Iterator<DashboardAccount> iterator() {
        return accounts.iterator();
    }

    public String getIp() {
        return ip;
    }

    public List<DashboardAccount> getAccounts() {
        return accounts;
    }

    public int getTotal() {
        return accounts.size();
    }

    public int getInGame() {
        return (int) accounts.stream().filter(account -> account.getStatus().equalsIgnoreCase("ingame")).count();
    }

    public int getInQueue() {
        return (int) accounts.stream().filter(account -> account.getStatus().equalsIgnoreCase("in-queue")).count();
    }

    public int getActive() {
        return getInQueue() + getInGame();
    }
}
