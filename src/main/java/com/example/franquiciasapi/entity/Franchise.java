package com.example.franquiciasapi.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tpro_franchise")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    @Column(name = "f_name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vendor> vendors;
}