package com.example.franquiciasapi.service;

import com.example.franquiciasapi.entity.Franchise;
import com.example.franquiciasapi.repository.FranchisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Franchise> getfranchiseById(Integer id) {
        return franchisesRepository.findById(id);
    }

}
