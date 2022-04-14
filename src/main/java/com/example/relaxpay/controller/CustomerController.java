package com.example.relaxpay.controller;

import com.example.relaxpay.request.CreateCustomerRequest;
import com.example.relaxpay.request.UpdateCustomerRequest;
import com.example.relaxpay.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping(value = "/create")
    public void createNewCustomer(@RequestBody CreateCustomerRequest request){
        customerService.createCustomer(request);
        log.info("Customer saved successfully");
    }

    @PostMapping(value = "/updateCustomer")
    public void updateNewCustomer(@RequestBody UpdateCustomerRequest request){
        log.info("Updating customer info");
        customerService.updateCustomer(request);
        log.info("Customer details updated");
    }
}
