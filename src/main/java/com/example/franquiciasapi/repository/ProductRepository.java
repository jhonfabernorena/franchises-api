package com.example.franquiciasapi.repository;

import com.example.franquiciasapi.entity.Product;
import com.example.franquiciasapi.entity.Vendor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByNameAndVendor(String name, Vendor VendorId);

    List<Product> findByVendor(Vendor vendor);

    Product findByVendorAndName(Vendor vendor, String ProductName);

}
