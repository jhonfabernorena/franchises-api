package com.example.franquiciasapi.service;

import com.example.franquiciasapi.exceptions.ResourceNotFoundException;
import com.example.franquiciasapi.entity.Vendor;
import com.example.franquiciasapi.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    private VendorRepository vendorRepository;
    private FranchiseService franchiseService;

    @Autowired
    public VendorService(VendorRepository vendorRepository, FranchiseService franchiseService) {
        this.vendorRepository = vendorRepository;
        this.franchiseService = franchiseService;
    }
    
    public Vendor createVendor(Integer franchiseId, Vendor vendor) {
        return franchiseService.getfranchiseById(franchiseId)
            .map(franchise -> {
                vendor.setFranchise(franchise);
                return vendorRepository.save(vendor);})
            .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada"));
    }
}
