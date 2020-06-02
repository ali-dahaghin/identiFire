package com.alidahaghin.identifire.models.formatElements.candidatesFormatElements;

import com.alidahaghin.identifire.models.FormatElement;
import com.alidahaghin.identifire.models.formatElements.CandidatesFormatElement;

import java.util.ArrayList;
import java.util.List;

public class LowerCaseFormatElement implements CandidatesFormatElement {

    @Override
    public List<String> getCandidates() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> candidates = new ArrayList<>();
        for (char c : alphabet) {
            candidates.add(String.valueOf(c));
        }
        return candidates;
    }

}
