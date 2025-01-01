package com.example.franquiciasapi.service;

import com.example.franquiciasapi.entity.Franchise;
import com.example.franquiciasapi.entity.Product;
import com.example.franquiciasapi.entity.Vendor;
import com.example.franquiciasapi.exceptions.ResourceNotFoundException;
import com.example.franquiciasapi.repository.FranchisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FranchiseService {

    @Autowired
    private FranchisesRepository franchisesRepository;

    public Franchise createFranchise(Franchise franchise) {
        return franchisesRepository.save(franchise);
    }

    public List<Franchise> getAllfranchises() {
        return franchisesRepository.findAll();
    }

    public Optional<Franchise> getFranchiseById(Integer id) {
        return franchisesRepository.findById(id);
    }

    public List<Vendor> findHigherStockProductsByFranchise(Integer franchiseId) {
        return getFranchiseById(franchiseId)
                .map(franchise -> franchise.getVendors().stream()
                        .map(vendor -> vendor.getProducts().stream()
                                .max(Comparator.comparingInt(Product::getStock))
                                .map(product -> {
                                    vendor.setProducts(Collections.singletonList(product));
                                    return vendor;})
                                .orElse(null))
                        .filter(Objects::nonNull)
                        .toList())
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada"));
    }
}
