package com.ias.practice.aves.infrastructure.models;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.*;

public class BirdDTO {
    private static Long id;
    private static String commonN;
    private static String scientificN;
    private static String zone;
    private static Integer quantity;

    private static String Status;

    public BirdDTO(Long id, String commonN, String scientificN, String zone, Integer quantity) {
        this.id = id;
        this.commonN = commonN;
        this.scientificN = scientificN;
        this.zone = zone;
        this.quantity = quantity;
    }

    public static Bird toDomain(){
        return new Bird(new IdBird(id),
                new CommonNameBird(commonN),
                new ScientificNameBird(scientificN),
                new ZoneNameBird(zone),
                new ConfirmedQuantityBird(quantity));

    }

    public static BirdDTO fromDomain(Bird bird){
        BirdDTO birdDTO = new BirdDTO(bird.getIdBird().getValue(),
                bird.getCommonNameBird().getValue(),
                bird.getScientificNameBird().getValue(),
                bird.getZoneNameBird().getValue(),
                bird.getConfirmedQuantityBird().getValue());

        return birdDTO;
    }

    public BirdDTO() {
    }

    public static void setStatus(String status) {
        Status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCommonN() {
        return commonN;
    }

    public String getScientificN() {
        return scientificN;
    }

    public String getZone() {
        return zone;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCommonN(String commonN) {
        this.commonN = commonN;
    }

    public void setScientificN(String scientificN) {
        this.scientificN = scientificN;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BirdDTO{" +
                "id=" + id +
                ", commonN='" + commonN + '\'' +
                ", scientificN='" + scientificN + '\'' +
                ", zone='" + zone + '\'' +
                ", quantity=" + quantity +
                ", Status=" + Status +
                '}';
    }
}
