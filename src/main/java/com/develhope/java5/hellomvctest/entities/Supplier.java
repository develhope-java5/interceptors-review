package com.develhope.java5.hellomvctest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {
    @Id
    private String identificationKey;
    private String name;
 
    public String getIdentificationKey() {
        return identificationKey;
    }

    public String getName() {
        return name;
    }
}
