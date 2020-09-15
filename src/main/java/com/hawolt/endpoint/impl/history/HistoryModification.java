package com.hawolt.endpoint.impl.history;

import org.json.JSONObject;

public class HistoryModification {
    private String id, name, region;

    public HistoryModification(JSONObject object) {
        this.id = object.getString("_id");
        this.name = object.getString("itemName");
        this.region = object.getString("itemRegion");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }
}
