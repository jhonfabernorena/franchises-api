package com.example.franquiciasapi.repository;

import com.example.franquiciasapi.entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FranchisesRepository extends JpaRepository<Franchise, Integer> {

    Optional<Franchise> findByName(String name);
}
