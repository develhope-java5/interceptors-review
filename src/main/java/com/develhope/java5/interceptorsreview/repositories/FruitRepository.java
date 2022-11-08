package com.develhope.java5.interceptorsreview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develhope.java5.interceptorsreview.entities.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    
}
