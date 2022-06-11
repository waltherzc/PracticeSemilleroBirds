package com.ias.practice.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ZoneNameBird {
    private final String value;

    public ZoneNameBird(String value) {
        Validate.notNull(value, "ZoneName can no be null");
        Validate.isTrue(value.length() <= 20,
                "ZoneName must to have less than 30 characters");

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
