package com.example.relaxpay.service.impl;

import com.example.relaxpay.dao.CustomerDAO;
import com.example.relaxpay.dao.CustomerVendorAccountDAO;
import com.example.relaxpay.dao.VendorDAO;
import com.example.relaxpay.dto.FetchDTO;
import com.example.relaxpay.model.Customer;
import com.example.relaxpay.model.CustomerVendorAccount;
import com.example.relaxpay.model.Vendor;
import com.example.relaxpay.request.CreateCustomerVendorAccountRequest;
import com.example.relaxpay.request.FetchAccountRequest;
import com.example.relaxpay.response.FetchAccountResponse;
import com.example.relaxpay.service.ICustomerVendorAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerVendorServiceImpl implements ICustomerVendorAccountService {
    @Autowired
    private CustomerVendorAccountDAO customerVendorAccountDAO;
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private VendorDAO vendorDAO;

    @Override
    public void createCustomerVendorAccount(CreateCustomerVendorAccountRequest request) {
        Customer customer = customerDAO.getByCustomerId(request.getCustomerId());
        if(customer == null){
            throw new RuntimeException("Customer not present please create customer first");
        }
        Vendor vendor = vendorDAO.getVendorByVendorId(request.getVendorID());
        if(vendor == null){
            throw new RuntimeException("Vendor not present please check");
        }
        validateRequestBodyData(request);
        CustomerVendorAccount account = new CustomerVendorAccount();
        account.setCustomer(customer);
        account.setVendor(vendor);
        account.setDateOfTransaction(request.getDateOfTransaction());
        account.setTransactionAmount(request.getTransactionAmount());
        account.setPendingAmount(request.getPendingAmount());
        account.setTransactionPurpose(request.getTransactionPurpose());
        account.setCustomerAccountNumber(request.getCustomerAccountNumber());
        account.setVendorAccountNumber(request.getVendorAccountNumber());
        account.setCreated(new Date());
        account.setUpdated(new Date());
        account.setCreatedBy("Admin");
        account.setUpdatedBy("Admin");
        customerVendorAccountDAO.save(account);
        account.setCustomerVendorRelationShipId(generateCustomerVendorRelationshipId(account));
        customerVendorAccountDAO.save(account);
        log.info("Account generated successfully");
    }

    @Override
    public List<FetchAccountResponse> fetchAccountDetails(FetchAccountRequest request) {
        List<String> customerIds = request.getDtos().stream().map(FetchDTO::getCustomerId).collect(Collectors.toList());
        List<String> vendorIds = request.getDtos().stream().map(FetchDTO::getVendorId).collect(Collectors.toList());
        List<CustomerVendorAccount> accounts = customerVendorAccountDAO.fetchAccountDetails(customerIds, vendorIds);
        List<FetchAccountResponse> responses = new ArrayList<>();
        for(CustomerVendorAccount account : accounts){
            FetchAccountResponse response = new FetchAccountResponse();
            response.setRefId(account.getCustomerVendorRelationShipId());
            response.setPurpose(account.getTransactionPurpose());
            response.setCustAccountNumber(account.getCustomerAccountNumber());
            response.setVendorAccountNumber(account.getVendorAccountNumber());
            response.setDateOfTransaction(account.getDateOfTransaction());
            responses.add(response);
        }
        return responses;
    }

    private String generateCustomerVendorRelationshipId(CustomerVendorAccount account) {
        StringBuilder relationShipId = new StringBuilder();
        relationShipId.append(account.getCustomer().getId()).append("00000").append(account.getVendor().getId());
        return relationShipId.toString();
    }

    private void validateRequestBodyData(CreateCustomerVendorAccountRequest request) {
        if(request.getCustomerAccountNumber() == null){
            throw new RuntimeException("Customer account number is missing");
        }
        else if(request.getPendingAmount()==null){
            throw new RuntimeException("Pending amount cant be null");
        }
        else if(request.getVendorAccountNumber()==null){
            throw new RuntimeException("Vendor account number cant be null");
        }
        else if(request.getTransactionAmount()==null){
            throw new RuntimeException("Transaction amount cant be null");
        }
        else if(request.getTransactionPurpose()==null){
            throw new RuntimeException("Transaction purpose cant be null");
        }
        else if(request.getDateOfTransaction()==null){
            throw new RuntimeException("Date of transaction cant be null");
        }
    }
}
