package com.example.franquiciasapi.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDto {
    private String id;
    private String name;
    private FranchiseDto franchise;  
    private List<ProductDto> products;  
}
