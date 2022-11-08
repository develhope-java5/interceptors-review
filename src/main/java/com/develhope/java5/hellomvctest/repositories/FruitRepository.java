package com.develhope.java5.hellomvctest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develhope.java5.hellomvctest.entities.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    
}
