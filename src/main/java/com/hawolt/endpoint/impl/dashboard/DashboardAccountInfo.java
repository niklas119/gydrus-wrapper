package com.hawolt.endpoint.impl.dashboard;

import org.json.JSONObject;

public class DashboardAccountInfo extends JSONObject {
    public DashboardAccountInfo(String username,String password, String region){
        put("summonerName",username);
        put("region",region);
        put("password",password);
    }
}
