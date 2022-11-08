package com.develhope.java5.hellomvctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.develhope.java5.hellomvctest.entities.Fruit;
import com.develhope.java5.hellomvctest.service.FruitService;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private FruitService service;

    @GetMapping
    public List<Fruit> getAllFruits() {
        return service.getAllFruits();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fruit insertOne(@RequestBody Fruit fruit) {
        return service.insert(fruit);
    }
    
}
