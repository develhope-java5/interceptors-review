package com.develhope.java5.hellomvctest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develhope.java5.hellomvctest.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    public Optional<Supplier> findByIdentificationKey(String identificationKey);
}
