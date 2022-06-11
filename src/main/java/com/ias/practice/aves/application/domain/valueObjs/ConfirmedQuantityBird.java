package com.ias.practice.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ConfirmedQuantityBird {
    private final Integer value;

    public ConfirmedQuantityBird(Integer value) {
        Validate.inclusiveBetween(1l,100000, value,
                "ConfirmedQuantity must be between 1 and 100000");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
