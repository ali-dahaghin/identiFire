package com.alidahaghin.identifire;

import com.alidahaghin.identifire.models.IdFireRepository;

public abstract class AbstractIdFire implements IdFire {

    protected final IdFireRepository idFireRepository;

    protected AbstractIdFire(IdFireRepository idFireRepository) {
        this.idFireRepository = idFireRepository;
    }
}
