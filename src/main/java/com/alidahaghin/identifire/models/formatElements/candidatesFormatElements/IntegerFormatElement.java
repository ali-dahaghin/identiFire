package com.alidahaghin.identifire.models.formatElements.candidatesFormatElements;

import com.alidahaghin.identifire.models.FormatElement;
import com.alidahaghin.identifire.models.formatElements.CandidatesFormatElement;

import java.util.ArrayList;
import java.util.List;

public class IntegerFormatElement implements CandidatesFormatElement {
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
