package com.hawolt.endpoint.impl.history;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoryModifications implements Iterable<HistoryModification> {
    private List<HistoryModification> modifications = new ArrayList<>();

    public HistoryModifications(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            modifications.add(new HistoryModification(array.getJSONObject(i)));
        }
    }

    @Override
    public Iterator<HistoryModification> iterator() {
        return modifications.iterator();
    }

    public List<HistoryModification> getModifications() {
        return modifications;
    }
}
