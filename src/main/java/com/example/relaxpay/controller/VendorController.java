package com.example.relaxpay.controller;

import com.example.relaxpay.request.CreateVendorRequest;
import com.example.relaxpay.service.IVendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class VendorController {

    @Autowired
    private IVendorService vendorService;

    @PostMapping(value = "/createVendor")
    public void createVendor(@RequestBody CreateVendorRequest request){
        vendorService.createVendor(request);
        log.info("Vendor created successfully");
    }
}
