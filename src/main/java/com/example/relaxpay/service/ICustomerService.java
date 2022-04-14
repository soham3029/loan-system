package com.example.relaxpay.service;

import com.example.relaxpay.request.CreateCustomerRequest;
import com.example.relaxpay.request.UpdateCustomerRequest;

public interface ICustomerService {
    public void createCustomer(CreateCustomerRequest request);
    public void updateCustomer(UpdateCustomerRequest request);
}
