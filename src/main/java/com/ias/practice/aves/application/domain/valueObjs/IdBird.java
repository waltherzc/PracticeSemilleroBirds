package com.ias.practice.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class IdBird {
    private final long value;

    public IdBird(long value) {
        Validate.notNull(value, "IdBird can no be null");
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
