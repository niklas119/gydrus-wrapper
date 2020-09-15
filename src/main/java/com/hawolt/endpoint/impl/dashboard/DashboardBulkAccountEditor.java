package com.hawolt.endpoint.impl.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

public class DashboardBulkAccountEditor extends JSONObject {

    private JSONObject object = new JSONObject();

    public DashboardBulkAccountEditor(DashboardAccount... accounts) {
        JSONArray array = new JSONArray();
        for (DashboardAccount account : accounts) {
            array.put(account.getId());
        }
        put("ids", array);
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
        object.put("disenchantEmblems", skipTutorial);
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
        object.put("desiredBE", stopBE);
    }

    public void setMissions(JSONObject missions) {
        object.put("missions", missions);
    }

    public void setStatus(String status) {
        object.put("status", status);
    }
}
