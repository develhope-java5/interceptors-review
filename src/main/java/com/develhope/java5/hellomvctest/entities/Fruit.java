package com.develhope.java5.hellomvctest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private long quantity;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public long getQuantity() {
        return quantity;
    }
}
