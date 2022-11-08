package com.develhope.java5.hellomvctest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develhope.java5.hellomvctest.entities.Supplier;
import com.develhope.java5.hellomvctest.repositories.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repository; 

    public Supplier insert(Supplier supplier) {
        return repository.saveAndFlush(supplier);
    }

    public boolean exists(String identificationKey) {
        return repository.findByIdentificationKey(identificationKey).isPresent();
    }
}
