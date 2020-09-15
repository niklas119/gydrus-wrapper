package com.hawolt.endpoint.impl.whitelist;

import org.json.JSONObject;

import java.time.Instant;

public class WhitelistEntry {

    private long createdAt;
    private String ownerName, ip, _id, ownerId, date;

    public WhitelistEntry(JSONObject o) {
        date = o.getString("createdAt");
        createdAt = Instant.parse(date).toEpochMilli();
        ownerName = o.getString("ownerName");
        ip = o.getString("ip");
        _id = o.getString("_id");
        ownerId = o.getString("ownerId");
    }

    public String getDate() {
        return date;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getIp() {
        return ip;
    }

    public String getId() {
        return _id;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
