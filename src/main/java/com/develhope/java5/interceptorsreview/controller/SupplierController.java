package com.develhope.java5.interceptorsreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develhope.java5.interceptorsreview.entities.Supplier;
import com.develhope.java5.interceptorsreview.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService service;
    
    @PostMapping
    public Supplier insertOne(@RequestBody Supplier supplier) {
        return service.insert(supplier);
    }
}
