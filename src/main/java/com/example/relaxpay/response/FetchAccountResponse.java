package com.example.relaxpay.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchAccountResponse {
    private String custAccountNumber;
    private String vendorAccountNumber;
    private String purpose;
    private Date dateOfTransaction;
    private String refId;
}
