package com.hawolt.endpoint.impl.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

public class FullDashboardAccount {
    private JSONObject object;

    private int blueEssence, desiredLevel, numberOfGames, currentLevel, gamesInSession, nextLevelPercentage, maxGames, desiredBE, priority, icon;
    private String displayName, completeMissionUntil, ip, summonerName, matchmakingStatus, ownerId, state, id, region, status, mode, flashOn, limitResources;
    private long playtime;
    private boolean active, disenchantLoot, disenchantFullChamps, disenchantFragChamps, showOnDashboard, disenchantEmblems, killExplorer, randomLanes, summonerNameTaken, skipIfNameTaken, skipTutorial, completeAllMissions;
    private JSONArray skins;
    private JSONObject blackWhiteListChamp, missionTracker, missions;

    public FullDashboardAccount(JSONObject object) {
        object = object.getJSONObject("data");
        this.object = object;
        this.blackWhiteListChamp = object.getJSONObject("blackWhiteListChamp");
        this.missionTracker = object.getJSONObject("missionTracker");
        this.missions = object.getJSONObject("missions");
        this.blueEssence = object.getInt("blueEssence");
        this.maxGames = object.getInt("maxGames");
        this.desiredBE = object.getInt("desiredBE");
        this.priority = object.getInt("priority");
        this.icon = object.getInt("icon");
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
        this.mode = object.getString("mode");
        this.flashOn = object.getString("flashOn");
        this.limitResources = object.getString("limitResources");
        this.disenchantFragChamps = object.getBoolean("disenchantFragChamps");
        this.disenchantFullChamps = object.getBoolean("disenchantFullChamps");
        this.showOnDashboard = object.getBoolean("showOnDashboard");
        this.disenchantEmblems = object.getBoolean("disenchantEmblems");
        this.killExplorer = object.getBoolean("killExplorer");
        this.randomLanes = object.getBoolean("randomLanes");
        this.summonerNameTaken = object.getBoolean("summonerNameTaken");
        this.skipIfNameTaken = object.getBoolean("skipIfNameTaken");
        this.skipTutorial = object.getBoolean("skipTutorial");
        this.completeAllMissions = object.getBoolean("completeAllMissions");
    }

    public DashboardAccount getAccount() {
        return new DashboardAccount(object);
    }

    JSONObject getObject() {
        return object;
    }

    public int getMaxGames() {
        return maxGames;
    }

    public int getDesiredBE() {
        return desiredBE;
    }

    public int getPriority() {
        return priority;
    }

    public int getIcon() {
        return icon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getMode() {
        return mode;
    }

    public String getFlashOn() {
        return flashOn;
    }

    public String getLimitResources() {
        return limitResources;
    }

    public boolean isDisenchantFullChamps() {
        return disenchantFullChamps;
    }

    public boolean isDisenchantFragChamps() {
        return disenchantFragChamps;
    }

    public boolean isShowOnDashboard() {
        return showOnDashboard;
    }

    public boolean isDisenchantEmblems() {
        return disenchantEmblems;
    }

    public boolean isKillExplorer() {
        return killExplorer;
    }

    public boolean isRandomLanes() {
        return randomLanes;
    }

    public boolean isSummonerNameTaken() {
        return summonerNameTaken;
    }

    public boolean isSkipIfNameTaken() {
        return skipIfNameTaken;
    }

    public boolean isSkipTutorial() {
        return skipTutorial;
    }

    public boolean isCompleteAllMissions() {
        return completeAllMissions;
    }

    public JSONObject getBlackWhiteListChamp() {
        return blackWhiteListChamp;
    }

    public JSONObject getMissionTracker() {
        return missionTracker;
    }

    public JSONObject getMissions() {
        return missions;
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
}
