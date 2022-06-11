package com.ias.practice.aves;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.*;

public class Test {


    public static void main(String[] args){

        Bird bird = new Bird(new IdBird(20),
                new CommonNameBird("Pato"),
                new ScientificNameBird("Patus"),
                new ZoneNameBird("Antioquia"),
                new ConfirmedQuantityBird(100));

        System.out.println(bird);
    }
}
