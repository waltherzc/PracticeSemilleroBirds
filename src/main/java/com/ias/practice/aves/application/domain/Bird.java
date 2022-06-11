package com.ias.practice.aves.application.domain;

import com.ias.practice.aves.application.domain.valueObjs.*;

public class Bird {
    private final IdBird idBird;
    private final CommonNameBird commonNameBird;
    private final ScientificNameBird scientificNameBird;
    private final ZoneNameBird zoneNameBird;
    private final ConfirmedQuantityBird confirmedQuantityBird;

    public Bird(IdBird idBird, CommonNameBird commonNameBird, ScientificNameBird scientificNameBird, ZoneNameBird zoneNameBird, ConfirmedQuantityBird confirmedQuantityBird) {
        this.idBird = idBird;
        this.commonNameBird = commonNameBird;
        this.scientificNameBird = scientificNameBird;
        this.zoneNameBird = zoneNameBird;
        this.confirmedQuantityBird = confirmedQuantityBird;
    }

    public IdBird getIdBird() {
        return idBird;
    }

    public CommonNameBird getCommonNameBird() {
        return commonNameBird;
    }

    public ScientificNameBird getScientificNameBird() {
        return scientificNameBird;
    }

    public ZoneNameBird getZoneNameBird() {
        return zoneNameBird;
    }

    public ConfirmedQuantityBird getConfirmedQuantityBird() {
        return confirmedQuantityBird;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "idBird=" + idBird +
                ", commonNameBird=" + commonNameBird +
                ", scientificNameBird=" + scientificNameBird +
                ", zoneNameBird=" + zoneNameBird +
                ", confirmedQuantityBird=" + confirmedQuantityBird +
                '}';
    }
}
