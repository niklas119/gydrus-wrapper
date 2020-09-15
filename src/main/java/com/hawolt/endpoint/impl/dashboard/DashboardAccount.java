package com.hawolt.endpoint.impl.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

public class DashboardAccount {
    private JSONObject object;

    private int blueEssence, desiredLevel, numberOfGames, currentLevel, gamesInSession, nextLevelPercentage;
    private String displayName, completeMissionUntil, ip, summonerName, matchmakingStatus, ownerId, state, id, region, status;
    private long playtime;
    private boolean active, disenchantLoot;
    private JSONArray skins;

    public DashboardAccount(JSONObject object) {
        this.object = object;
        this.blueEssence = object.getInt("blueEssence");
        this.displayName = object.getString("displayName");
        this.desiredLevel = object.getInt("desiredLevel");
        this.ip = object.getString("ip");
        this.summonerName = object.getString("summonerName");
        this.matchmakingStatus = object.getString("matchmakingStatus");
        this.playtime = object.getLong("playtime");
        this.active = object.getBoolean("isActive");
        this.ownerId = object.getString("ownerId");
        this.numberOfGames = object.getInt("nOfGames");
        this.currentLevel = object.getInt("currentLevel");
        this.skins = object.getJSONArray("skins");
        this.disenchantLoot = object.getBoolean("disenchantLoot");
        this.state = object.getString("state");
        this.gamesInSession = object.getInt("gamesInSession");
        this.id = object.getString("_id");
        this.completeMissionUntil = object.getString("completeMissionUntil");
        this.nextLevelPercentage = object.getInt("nextLevelPercentage");
        this.region = object.getString("region");
        this.status = object.getString("status");
    }

    JSONObject getObject() {
        return object;
    }

    public int getBlueEssence() {
        return blueEssence;
    }

    public int getDesiredLevel() {
        return desiredLevel;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getGamesInSession() {
        return gamesInSession;
    }

    public int getNextLevelPercentage() {
        return nextLevelPercentage;
    }

    public String getSummonerName() {
        return displayName;
    }

    public String getCompleteMissionUntil() {
        return completeMissionUntil;
    }

    public String getIp() {
        return ip;
    }

    public String getLoginName() {
        return summonerName;
    }

    public String getMatchmakingStatus() {
        return matchmakingStatus;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getStatus() {
        return status;
    }

    public long getPlaytime() {
        return playtime;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isDisenchantLoot() {
        return disenchantLoot;
    }

    public JSONArray getSkins() {
        return skins;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
