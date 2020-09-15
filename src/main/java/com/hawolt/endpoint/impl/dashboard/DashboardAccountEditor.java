package com.hawolt.endpoint.impl.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

public class DashboardAccountEditor extends JSONObject {

    private JSONObject object = new JSONObject();

    public DashboardAccountEditor(DashboardAccount account) {
        JSONArray array = new JSONArray();
        array.put(account.getId());
        put("ids", array);
        object.put("__v", 0);
        object.put("password", "");
        setActive(account.isActive());
        setDisenchantLoot(account.isDisenchantLoot());
        setDesiredLevel(account.getDesiredLevel());
        setState(account.getState());
        setIP(account.getIp());
        setBE(account.getBlueEssence());
        setID(account.getId());
        setSkins(account.getSkins());
        setRegion(account.getRegion());
        setPlaytime(account.getPlaytime());
        setMatchmakingStatus(account.getMatchmakingStatus());
        setSummonerName(account.getLoginName());
        setDisplayName(account.getSummonerName());
        setCompleteMissionUntil(Integer.parseInt(account.getCompleteMissionUntil()));
        setNumberOfGames(account.getNumberOfGames());
        setCurrentLevel(account.getCurrentLevel());
        setGamesInSession(account.getGamesInSession());
        setNextLevelPercentage(account.getNextLevelPercentage());
    }

    private void setIP(String ip) {
        object.put("ip", ip);
    }

    private void setMatchmakingStatus(String matchmaking) {
        object.put("matchmakingStatus", matchmaking);
    }

    private void setSkins(JSONArray skins) {
        object.put("skins", skins);
    }

    private void setPlaytime(long playTime) {
        object.put("playtime", playTime);
    }

    private void setSummonerNameTaken(boolean nameTaken) {
        object.put("summonerNameTaken", nameTaken);
    }

    private void setState(String state) {
        object.put("state", state);
    }

    private void setFlashOn(String key) {
        object.put("flashOn", key);
    }

    private void setNumberOfGames(int gameNumber) {
        object.put("nOfGames", gameNumber);
    }

    private void setCompleteMissionUntil(int missionUntil) {
        object.put("completeMissionUntil", String.valueOf(missionUntil));
    }

    private void setLimitResources(double resourceLimit) {
        object.put("limitResources", String.valueOf(resourceLimit));
    }

    private void setCompleteAllMissions(boolean completeAllMissions) {
        object.put("completeAllMissions", completeAllMissions);
    }

    private void setCurrentLevel(int level) {
        object.put("currentLevel", 9);
    }

    private void setDisplayName(String displayName) {
        object.put("displayName", displayName);
    }

    private void setMissionTracker(JSONObject tracker) {
        object.put("missionTracker", tracker);
    }

    private void setMode(String mode) {
        object.put("mode", mode);
    }

    private void setBlackWhiteListChamp(JSONObject list) {
        object.put("blackWhiteListChamp", list);
    }

    private void setBE(int be) {
        object.put("blueEssence", be);
    }

    private void setNextLevelPercentage(int percent) {
        object.put("nextLevelPercentage", percent);
    }

    public JSONObject getObject() {
        return object;
    }

    public JSONObject getFinalized() {
        return this.put("updatedFields", object);
    }

    public void setActive(boolean active) {
        object.put("isActive", active);
    }

    public void setShowOnDashboard(boolean showOnDashboard) {
        object.put("showOnDashboard", showOnDashboard);
    }

    public void setDisenchantEmblems(boolean disenchantEmblems) {
        object.put("disenchantEmblems", disenchantEmblems);
    }

    public void setSkipTutorial(boolean skipTutorial) {
        object.put("skipTutorial", skipTutorial);
    }

    public void setSkipIfName(boolean skipIfName) {
        object.put("skipIfNameTaken", skipIfName);
    }

    public void setDisenchantLoot(boolean disenchantLoot) {
        object.put("disenchantLoot", disenchantLoot);
    }

    public void setDisenchantFragment(boolean disenchantFragment) {
        object.put("disenchantFragChamps", disenchantFragment);
    }

    public void setKillExplorer(boolean killExplorer) {
        object.put("killExplorer", killExplorer);
    }

    public void setDisenchantChampion(boolean disenchantChampion) {
        object.put("disenchantFullChamps", disenchantChampion);
    }

    public void setRandomLane(boolean randomLane) {
        object.put("randomLanes", randomLane);
    }

    public void setMaxGames(int maxGames) {
        object.put("maxGames", maxGames);
    }

    public void setDesiredLevel(int desiredLevel) {
        object.put("desiredLevel", desiredLevel);
    }

    public void setIconID(int iconID) {
        object.put("icon", iconID);
    }


    public void setPriority(int priority) {
        object.put("priority", priority);
    }

    public void setStopBE(int stopBE) {
        object.put("desiredBE", String.valueOf(stopBE));
    }

    public void setMissions(JSONObject missions) {
        object.put("missions", missions);
    }

    public void setStatus(String status) {
        object.put("status", status);
    }

    public void setRegion(String region) {
        object.put("region", region);
    }

    public void setSummonerName(String name) {
        object.put("summonerName", name);
    }

    public void setID(String id) {
        object.put("_id", id);
    }

    public void setGamesInSession(int games) {
        object.put("gamesInSession", games);
    }
}
