package com.example.franquiciasapi.repository;

import com.example.franquiciasapi.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    Optional<Vendor> findByNameAndFranchise(String name, String franchiseId);

    List<Vendor> findByFranchise(String franchiseId);

    Vendor save(Vendor Vendor);

}
