package com.alidahaghin.identifire.models.formatElements;

import com.alidahaghin.identifire.models.FormatElement;

import java.util.ArrayList;
import java.util.List;

public class StringFormatElement implements FormatElement {

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
