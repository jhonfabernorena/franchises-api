package com.example.franquiciasapi.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "p_name", nullable = false)
    private String name;
    @Column(name = "p_quantity", nullable = false)
    private Integer stock;
    @ManyToOne()
    @JoinColumn(name = "p_vendor_id")
    private Vendor vendor;
}