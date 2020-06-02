package com.alidahaghin.identifire.models.formatElements;

import com.alidahaghin.identifire.models.FormatElement;

public class ParameterFormatElement implements FormatElement {

    private String key;

    public ParameterFormatElement(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
