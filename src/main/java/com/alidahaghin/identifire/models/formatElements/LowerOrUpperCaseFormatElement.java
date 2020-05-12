package com.alidahaghin.identifire.models.formatElements;

import com.alidahaghin.identifire.models.FormatElement;

import java.util.ArrayList;
import java.util.List;

public class LowerOrUpperCaseFormatElement implements FormatElement {
    @Override
    public List<String> getCandidates() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<String> candidates = new ArrayList<>();
        for (char c : alphabet) {
            candidates.add(String.valueOf(c));
        }
        return candidates;
    }
}
