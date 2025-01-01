package com.example.franquiciasapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private Integer stock;
    private VendorDto vendor; 
}
