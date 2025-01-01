package com.example.franquiciasapi.entity;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tpro_product")
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
    @JsonIgnoreProperties("products")
    private Vendor vendor;
}