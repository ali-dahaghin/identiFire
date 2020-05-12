package com.alidahaghin.identifire.models.formatElements;

import com.alidahaghin.identifire.models.FormatElement;

import java.util.ArrayList;
import java.util.List;

public class IntegerOrUpperOrLowerCaseFormatElements implements FormatElement {
    @Override
    public List<String> getCandidates() {
        char[] alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<String> candidates = new ArrayList<>();
        for (char c : alphabet) {
            candidates.add(String.valueOf(c));
        }
        return candidates;
    }
}
