package com.develhope.java5.interceptorsreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develhope.java5.interceptorsreview.entities.Fruit;
import com.develhope.java5.interceptorsreview.repositories.FruitRepository;

@Service
public class FruitService {
    @Autowired
    private FruitRepository repository;
    
    public List<Fruit> getAllFruits() {
        return repository.findAll(); 
    }

    public Fruit insert(Fruit fruit) {
        return repository.saveAndFlush(fruit);
    }
}
