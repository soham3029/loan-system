package com.example.relaxpay.request;

import com.example.relaxpay.dto.UpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    private Integer id;
    private UpdateDTO updateDTO;
}
