package com.hawolt.endpoint.impl.credentials;

import org.json.JSONArray;
import org.json.JSONObject;

public class AccountInfo {
    private String name, status, matchmaking, id, summonerName, region, password,flashOn;
    private int level, be, levelPercentage, v;
    private boolean disenchantLoot, showOnDashboard;
    private JSONArray skins;

    public AccountInfo(JSONObject object) {
        this.name = object.getString("displayName");
        this.flashOn = object.getString("flashOn");
        this.level = object.getInt("currentLevel");
        this.status = object.getString("status");
        this.matchmaking = object.getString("matchmakingStatus");
        this.skins = object.getJSONArray("skins");
        this.disenchantLoot = object.getBoolean("disenchantLoot");
        this.be = object.getInt("blueEssence");
        this.showOnDashboard = object.getBoolean("showOnDashboard");
        this.levelPercentage = object.getInt("nextLevelPercentage");
        this.id = object.getString("_id");
        this.summonerName = object.getString("summonerName");
        this.region = object.getString("region");
        this.password = object.getString("password");
        this.v = object.getInt("__v");
    }

    public String getName() {
        return name;
    }

    public String getFlashOn() {
        return flashOn;
    }

    public String getSummonerName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getMatchmaking() {
        return matchmaking;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return summonerName;
    }

    public String getRegion() {
        return region;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getBe() {
        return be;
    }

    public int getLevelPercentage() {
        return levelPercentage;
    }

    public int getV() {
        return v;
    }

    public boolean isDisenchantLoot() {
        return disenchantLoot;
    }

    public boolean isShowOnDashboard() {
        return showOnDashboard;
    }

    public JSONArray getSkins() {
        return skins;
    }
}
