package com.example.franquiciasapi.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDto {
    private String nombre;
    private List<ProductDto> productos;
}