package com.example.franquiciasapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String nombre;
    private int stock;
}