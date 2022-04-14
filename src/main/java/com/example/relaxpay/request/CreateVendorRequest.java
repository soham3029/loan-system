package com.example.relaxpay.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVendorRequest {
    private String vendorName;
    private String panCardNumber;
    private String phoneNumber;
    private String emailAddress;
    private BigDecimal amountToBeReceived;
}
