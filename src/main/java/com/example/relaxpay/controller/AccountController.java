package com.example.relaxpay.controller;

import com.example.relaxpay.request.CreateCustomerVendorAccountRequest;
import com.example.relaxpay.request.FetchAccountRequest;
import com.example.relaxpay.response.FetchAccountResponse;
import com.example.relaxpay.service.ICustomerVendorAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class AccountController {
    @Autowired
    private ICustomerVendorAccountService service;

    @PostMapping(value = "/generateAccount")
    public void generateAccount(@RequestBody CreateCustomerVendorAccountRequest request){
      log.info("Generation account for customer vendor");
      service.createCustomerVendorAccount(request);
      log.info("Account generation successful");
    }

    @PostMapping("/fetchAccount")
    public List<FetchAccountResponse> getAccountDetails(@RequestBody FetchAccountRequest request){
        log.info("Fetching loan account details");
        return service.fetchAccountDetails(request);
    }
}
