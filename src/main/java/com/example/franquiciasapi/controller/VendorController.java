package com.example.franquiciasapi.controller;


import com.example.franquiciasapi.entity.Vendor;
import com.example.franquiciasapi.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/{franquiciaId}")
    public ResponseEntity<Vendor> addVendor(@PathVariable Integer franchiseId, @RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.createVendor(franchiseId, vendor));
    }
}