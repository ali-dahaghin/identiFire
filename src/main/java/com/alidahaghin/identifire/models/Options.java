package com.alidahaghin.identifire.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Options {

    protected Map<String, List<String>> params = new HashMap<>();

    public static Options getEmpty() {
        return new Options();
    }

    public static Options getWithParam(Map<String, List<String>> params) {
        Options options = Options.getEmpty();
        options.setParams(params);
        return options;
    }

    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    public void setParam(String key, List<String> value) {
        this.params.put(key, value);
    }

    public void setParam(String key, String value) {
        if (this.params.containsKey(key)) {
            this.params.get(key).add(value);
        } else {
            List<String> candidates = new ArrayList<>();
            candidates.add(value);
            this.params.put(key, candidates);
        }

    }

    public Map<String, List<String>> getParams() {
        return new HashMap<>(this.params).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, stringListEntry -> new ArrayList<>(stringListEntry.getValue())));
    }

    public List<String> getParam(String key) {
        return params.get(key);
    }

}
