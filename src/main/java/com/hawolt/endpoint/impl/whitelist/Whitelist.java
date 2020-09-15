package com.hawolt.endpoint.impl.whitelist;

import com.hawolt.InitializationException;
import com.hawolt.endpoint.Tab;
import com.hawolt.endpoint.impl.history.HistoryEntry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Whitelist extends Tab implements Iterable<WhitelistEntry> {

    private List<WhitelistEntry> entries = new ArrayList<>();

    public Whitelist(String resource) throws IOException, InitializationException {
        super(resource);
        JSONObject response = new JSONObject(this.response);
        JSONArray data = response.getJSONArray("data");
        for (int i = 0; i < data.length(); i++) {
            entries.add(new WhitelistEntry(data.getJSONObject(i)));
        }
    }

    @Override
    public Iterator<WhitelistEntry> iterator() {
        return entries.iterator();
    }

    public List<WhitelistEntry> getEntries() {
        return entries;
    }
}
