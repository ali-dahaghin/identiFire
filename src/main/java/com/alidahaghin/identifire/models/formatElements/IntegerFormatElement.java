package com.alidahaghin.identifire.models.formatElements;

import com.alidahaghin.identifire.models.FormatElement;

import java.util.ArrayList;
import java.util.List;

public class IntegerFormatElement implements FormatElement {
    @Override
    public List<String> getCandidates() {
        char[] integers = "0123456789".toCharArray();
        List<String> candidates = new ArrayList<>();
        for (char c : integers) {
            candidates.add(String.valueOf(c));
        }
        return candidates;
    }
}
