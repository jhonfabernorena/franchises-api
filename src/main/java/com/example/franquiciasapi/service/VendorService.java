package com.example.franquiciasapi.service;

import com.example.franquiciasapi.exceptions.ResourceNotFoundException;
import com.example.franquiciasapi.entity.Vendor;
import com.example.franquiciasapi.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorService {

    private VendorRepository vendorRepository;
    private FranchiseService franchiseService;

    @Autowired
    public VendorService(VendorRepository vendorRepository, FranchiseService franchiseService) {
        this.vendorRepository = vendorRepository;
        this.franchiseService = franchiseService;
    }

    public Optional<Vendor> findVendorById(Integer id) {
        return vendorRepository.findById(id);
    }
    
    public Vendor createVendor(Integer franchiseId, Vendor vendor) {
        return franchiseService.getFranchiseById(franchiseId)
            .map(franchise -> {
                vendor.setFranchise(franchise);
                vendor.getProducts().forEach(product -> {product.setVendor(vendor);});
                return vendorRepository.save(vendor);})
            .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada"));
    }
}
