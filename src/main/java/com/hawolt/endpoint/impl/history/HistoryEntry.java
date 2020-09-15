package com.hawolt.endpoint.impl.history;

import org.json.JSONObject;

public class HistoryEntry {
    private HistoryModifications historyModifications;
    private String title, id, ownerId, event, date;
    private int v;

    public HistoryEntry(JSONObject object) {
        this.title = object.getString("title");
        this.id = object.getString("_id");
        this.historyModifications = new HistoryModifications(object.getJSONArray("itemsModified"));
        this.ownerId = object.getString("ownerId");
        this.event = object.getString("eventType");
        this.date = object.getString("date");
        this.v = object.getInt("__v");
    }

    public HistoryModifications getHistoryModifications() {
        return historyModifications;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getEvent() {
        return event;
    }

    public String getDate() {
        return date;
    }

    public int getV() {
        return v;
    }
}
