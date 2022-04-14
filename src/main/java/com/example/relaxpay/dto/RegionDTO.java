package com.example.relaxpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionDTO {
    private String state;
    private String zipCode;
    private String city;
    private String addressLine1;
    private String addressLine2;
}
