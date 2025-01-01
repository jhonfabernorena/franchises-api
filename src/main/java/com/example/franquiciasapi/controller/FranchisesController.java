package com.example.franquiciasapi.controller;

import com.example.franquiciasapi.entity.Franchise;
import com.example.franquiciasapi.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class FranchisesController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseService.createFranchise(franchise);
    }

    @GetMapping
    public List<Franchise> getAllFranchises() {
        return franchiseService.getAllfranchises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranquiciaById(@PathVariable Integer id) {
        ResponseEntity.ok(franchiseService.getfranchiseById(id));
                return null;
    }
}