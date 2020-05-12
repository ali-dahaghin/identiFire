package com.alidahaghin.identifire;

import com.alidahaghin.identifire.models.Storage;

public abstract class AbstractIdentifire implements Identifire {

    protected final Storage storage;

    protected AbstractIdentifire(Storage storage) {
        this.storage = storage;
    }
}
