package com.example.franquiciasapi.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseDto {
    private String id;
    private String name;
    private List<VendorDto> vendors;
}
