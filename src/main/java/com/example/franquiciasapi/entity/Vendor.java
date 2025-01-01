package com.example.franquiciasapi.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tpro_vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    @Column(name = "s_name", nullable = false)
    private String name;

    @JsonIgnoreProperties("vendors")    @ManyToOne()
    @JoinColumn(name = "s_franchise_id")
    private Franchise franchise;
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("vendor")
    private List<Product> products;
}