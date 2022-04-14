package com.example.relaxpay.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private BigDecimal amountToBeTransferred;
}
