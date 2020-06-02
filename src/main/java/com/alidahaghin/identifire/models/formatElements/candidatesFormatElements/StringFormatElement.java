package com.alidahaghin.identifire.models.formatElements.candidatesFormatElements;

import com.alidahaghin.identifire.models.FormatElement;
import com.alidahaghin.identifire.models.formatElements.CandidatesFormatElement;

import java.util.ArrayList;
import java.util.List;

public class StringFormatElement implements CandidatesFormatElement {

    private List<String> strings;

    public StringFormatElement() {
        this.strings = new ArrayList<>();
    }

    public StringFormatElement(List<String> strings) {
        this.strings = strings;
    }

    public void addString(String string) {
        this.strings.add(string);
    }

    @Override
    public List<String> getCandidates() {
        return strings;
    }
}
