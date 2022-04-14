package com.example.relaxpay.service;

import com.example.relaxpay.request.CreateCustomerVendorAccountRequest;
import com.example.relaxpay.request.FetchAccountRequest;
import com.example.relaxpay.response.FetchAccountResponse;

import java.util.List;

public interface ICustomerVendorAccountService {
    public void createCustomerVendorAccount(CreateCustomerVendorAccountRequest request);
    public List<FetchAccountResponse> fetchAccountDetails(FetchAccountRequest request);
}
