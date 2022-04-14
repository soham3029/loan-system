package com.example.relaxpay.service.impl;

import com.example.relaxpay.constants.CustomerOrVendor;
import com.example.relaxpay.dao.CustomerVendorDAO;
import com.example.relaxpay.dao.VendorDAO;
import com.example.relaxpay.model.CustomerVendor;
import com.example.relaxpay.model.Vendor;
import com.example.relaxpay.request.CreateVendorRequest;
import com.example.relaxpay.service.IVendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class VendorServiceImpl implements IVendorService {

    @Autowired
    private VendorDAO vendorDAO;

    @Autowired
    private CustomerVendorDAO customerVendorDAO;

    @Override
    public void createVendor(CreateVendorRequest request) {
        validateRequestBodyData(request);
        Vendor vendor = new Vendor();
        vendor.setVendorName(request.getVendorName());
        vendor.setEmailAddress(request.getEmailAddress());
        vendor.setPanCardNumber(request.getPanCardNumber());
        vendor.setPhoneNumber(request.getPhoneNumber());
        vendor.setAmountToBeReceived(request.getAmountToBeReceived());
        List<Vendor> vendors = new ArrayList<>();
        createCustomerVendor(request, vendors);
        vendorDAO.save(vendor);
        vendor.setVendorId(generateVendorId(vendor));
        vendorDAO.save(vendor);
        log.info("Vendor saved successfully");
    }

    private String generateVendorId(Vendor vendor) {
        StringBuilder vendorId = new StringBuilder();
        vendorId.append("VENDOR").append(vendor.getId());
        return vendorId.toString();
    }

    private void createCustomerVendor(CreateVendorRequest request, List<Vendor> vendors) {
        CustomerVendor customerVendor = new CustomerVendor();
        customerVendor.setVendors(vendors);
        customerVendor.setCreated(new Date());
        customerVendor.setUpdated(new Date());
        customerVendor.setCreatedBy("Admin");
        customerVendor.setType(CustomerOrVendor.VENDOR);
        customerVendorDAO.save(customerVendor);
        log.info("Customer vendor saved successfully");
    }

    private void validateRequestBodyData(CreateVendorRequest request) {
        if(request.getVendorName() == null){
            throw new RuntimeException("Vendor name field is empty");
        }
        else if(request.getEmailAddress() == null){
            throw new RuntimeException("Vendor email id is empty");
        }
        else if(request.getPanCardNumber() == null){
            throw new RuntimeException("Vendor Pan card number is empty");
        }
        else if(request.getPhoneNumber() == null){
            throw new RuntimeException("Phone number is missing");
        }
        else if(request.getAmountToBeReceived() == null){
            throw new RuntimeException("The amount to be received is missing");
        }
    }
}
