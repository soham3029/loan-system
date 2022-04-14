package com.example.relaxpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDTO {
    private String panCardNumber;
    private RegionDTO regionDTO;
}
