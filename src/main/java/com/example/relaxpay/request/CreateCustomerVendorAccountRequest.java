package com.example.relaxpay.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerVendorAccountRequest {
    private String customerId;
    private String vendorID;
    private String customerAccountNumber;
    private String vendorAccountNumber;
    private BigDecimal transactionAmount;
    private BigDecimal pendingAmount;
    private String transactionPurpose;
    private Date dateOfTransaction;
}
