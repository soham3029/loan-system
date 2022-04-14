package com.example.relaxpay.constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum CustomerOrVendor {
    CUSTOMER("customer"),
    VENDOR("vendor");
    private String value;
}
