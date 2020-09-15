package com.hawolt.endpoint.impl.history;

import com.hawolt.InitializationException;
import com.hawolt.endpoint.Tab;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class History extends Tab implements Iterable<HistoryEntry> {

    private List<HistoryEntry> entries = new ArrayList<>();

    public History(String resource) throws IOException, InitializationException {
        super(resource);
        JSONObject response = new JSONObject(this.response);
        JSONArray data = response.getJSONArray("data");
        for (int i = 0; i < data.length(); i++) {
            entries.add(new HistoryEntry(data.getJSONObject(i)));
        }
    }

    @Override
    public Iterator<HistoryEntry> iterator() {
        return entries.iterator();
    }

    public List<HistoryEntry> getEntries() {
        return entries;
    }
}
