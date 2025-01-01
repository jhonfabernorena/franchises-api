package com.example.franquiciasapi.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    @Column(name = "s_name", nullable = false)
    private String name;
    @ManyToOne()
    @JoinColumn(name = "s_franchise_id")
    private Franchise franchise;
    @OneToMany(mappedBy = "tpro_vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}