package com.ias.practice.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ScientificNameBird {
    private final String value;


    public ScientificNameBird(String value) {
        Validate.notNull(value, "ScientificName can no be null");
        Validate.isTrue(value.length() <= 30,
                "ScientificName must to have less than 30 characters");

        this.value = value;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return  value;
    }
}
