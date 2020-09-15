package com.hawolt.endpoint.impl.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

public class DashboardAccountAddition extends JSONObject {
    private JSONObject object = new JSONObject();

    public DashboardAccountAddition(DashboardAccountInfo... information) {
        JSONArray array = new JSONArray();
        for (DashboardAccountInfo account : information) {
            array.put(account);
        }
        put("formattedAccounts", array);

        JSONObject missions = new JSONObject();
        missions.put("1", "ahri");
        missions.put("2", "caitlyn");
        missions.put("3", "illaoi");
        missions.put("4", "brand");
        missions.put("5", "thresh");
        missions.put("6", "ekko");
        object.put("missions", missions);

        setMode("normal");
        setFlashOn("f");
        setDesiredLevel(30);
        setMaxGames(500);
        setIconId(14);
        setPriority(1);
        setDesiredBE(0);
        setDisenchantLoot(true);

        setResourceLimit(0.8f);
        setCompleteMissionUntil(8);
        setCompleteAllMissions(true);

        setDisenchantFragmentChampions(false);
        setDisenchantFullChampions(false);
        setDisenchantEmblems(true);
        setRandomLanes(false);
        setSkipIfNameTaken(true);
        setKillExplorer(true);
        setSkipTutorial(false);

        setChampion(false, 523, 8);
    }

    public JSONObject getFinalized() {
        return this.put("settings", object);
    }

    public void setMode(String value) {
        object.put("mode", value);
    }

    public void setFlashOn(String value) {
        object.put("flashOn", value);
    }

    public void setDisenchantLoot(boolean b) {
        object.put("disenchantLoot", b);
    }

    public void setCompleteAllMissions(boolean b) {
        object.put("completeAllMissions", b);
    }

    public void setCompleteMissionUntil(int stage) {
        object.put("completeMissionUntil", stage);
    }

    public void setResourceLimit(float limit) {
        object.put("limitResources", limit);
    }

    public void setChampion(boolean whitelist, int... ids) {
        JSONObject data = new JSONObject();
        data.put("enabled", true);
        data.put("option", whitelist ? "whitelist" : "blacklist");
        JSONArray array = new JSONArray();
        for (int i = 0; i < ids.length; i++) {
            array.put(ids[i]);
        }
        data.put("ids", array);
        object.put("blackWhiteListChamp", data);
    }


    public void setDisenchantFragmentChampions(boolean b) {
        object.put("disenchantFragChamps", b);
    }

    public void setDisenchantFullChampions(boolean b) {
        object.put("disenchantFullChamps", b);
    }

    public void setDisenchantEmblems(boolean b) {
        object.put("disenchantEmblems", b);
    }

    public void setRandomLanes(boolean b) {
        object.put("randomLanes", b);
    }

    public void setSkipIfNameTaken(boolean b) {
        object.put("skipIfNameTaken", b);
    }

    public void setKillExplorer(boolean b) {
        object.put("killExplorer", b);
    }

    public void setSkipTutorial(boolean b) {
        object.put("skipTutorial", b);
    }

    public void setDesiredLevel(int level) {
        object.put("desiredLevel", level);
    }

    public void setDesiredBE(int be) {
        object.put("desiredBE", be);
    }

    public void setMaxGames(int games) {
        object.put("maxGames", games);
    }

    public void setIconId(int id) {
        object.put("icon", id);
    }

    public void setPriority(int priority) {
        object.put("priority", priority);
    }
}
