package com.ias.practice.aves.infrastructure.models;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BirdDAO {
    private static Long id;
    private static String commonN;
    private static String scientificN;
    private static String zone;
    private static Integer quantity;

    public BirdDAO(Long id, String commonN, String scientificN, String zone, Integer quantity) {
        this.id = id;
        this.commonN = commonN;
        this.scientificN = scientificN;
        this.zone = zone;
        this.quantity = quantity;
    }

    public BirdDAO() {
    }

    public static Bird toDomain(){
        return new Bird(new IdBird(id), new CommonNameBird(commonN),
                new ScientificNameBird(scientificN), new ZoneNameBird(zone),
                new ConfirmedQuantityBird(quantity));

    }

    public static BirdDAO fromDomain(Bird bird){
        BirdDAO birdDAO = new BirdDAO();
        birdDAO.setId(bird.getIdBird().getValue());
        birdDAO.setCommonN(bird.getCommonNameBird().getValue());
        birdDAO.setScientificN(bird.getScientificNameBird().getValue());
        birdDAO.setZone(bird.getZoneNameBird().getValue());
        birdDAO.setQuantity(bird.getConfirmedQuantityBird().getValue());
        return birdDAO;
    }

    public static BirdDAO fromResultSet(ResultSet resultSet) throws SQLException {
        BirdDAO birdDAO = new BirdDAO();
        birdDAO.setId(resultSet.getLong("id"));
        birdDAO.setCommonN(resultSet.getString("common_name"));
        birdDAO.setScientificN(resultSet.getString("scientific_name"));
        birdDAO.setZone(resultSet.getString("zone_name"));
        birdDAO.setQuantity(resultSet.getInt("confirmed_quantity"));

        return birdDAO;
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
        return "BirdDAO{" +
                "id=" + id +
                ", commonN='" + commonN + '\'' +
                ", scientificN='" + scientificN + '\'' +
                ", zone='" + zone + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
