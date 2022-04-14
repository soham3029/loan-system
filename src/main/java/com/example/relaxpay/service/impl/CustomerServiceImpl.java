package com.example.relaxpay.service.impl;

import com.example.relaxpay.dao.CustomerDAO;
import com.example.relaxpay.dao.CustomerVendorDAO;
import com.example.relaxpay.model.Customer;
import com.example.relaxpay.model.CustomerVendor;
import com.example.relaxpay.request.CreateCustomerRequest;
import com.example.relaxpay.request.UpdateCustomerRequest;
import com.example.relaxpay.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerVendorDAO customerVendorDAO;

    @Override
    public void createCustomer(CreateCustomerRequest request) {
        validateRequestBody(request);
        List<Customer> customers = new ArrayList<>();
        log.info("Creating New Customer");
        Customer customer = new Customer();
        customer.setId(request.getId());
        customer.setCustomerName(request.getName());
        customer.setEmailAddress(request.getEmailAddress());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAmountToBeTransferred(request.getAmountToBeTransferred());
        customer.setCreated(new Date());
        customer.setUpdated(new Date());
        customer.setCreatedBy("Admin");
        customer.setUpdatedBy("Admin");
        customers.add(customer);
        CustomerVendor customerVendor = createCustomerVendor(request, customers);
        customer.setCustomerVendor(customerVendor);
        customerDAO.save(customer);
        customer.setCustomerId(generateCustomerId(customer));
        customerDAO.save(customer);
        log.info("Customer saved successfully");
    }

    private String generateCustomerId(Customer customer) {
        StringBuilder customerId = new StringBuilder();
        customerId.append("RPS");
        customerId.append("000").append(customer.getId());
        return customerId.toString();
    }

    @Override
    public void updateCustomer(UpdateCustomerRequest request) {
        Customer customer = customerDAO.getById(request.getId());
        if(customer==null){
            throw new RuntimeException("Customer not present to update");
        }
        else {
            customer.setPanCardNumber(request.getUpdateDTO().getPanCardNumber());
            customer.setState(request.getUpdateDTO().getRegionDTO().getState());
            customer.setCity(request.getUpdateDTO().getRegionDTO().getCity());
            customer.setAddressLine1(request.getUpdateDTO().getRegionDTO().getAddressLine1());
            customer.setAddressLine2(request.getUpdateDTO().getRegionDTO().getAddressLine2());
            customer.setZipCode(request.getUpdateDTO().getRegionDTO().getZipCode());
            customer.setUpdatedBy("Admin");
            customer.setUpdated(new Date());
            List<Customer> customers = new ArrayList<>();
            customers.add(customer);
            CustomerVendor customerVendor = updateCustomerVendor(customers);
            customer.setCustomerVendor(customerVendor);
            customerDAO.save(customer);
            log.info("Customer details updated successfully");
        }
    }

    private CustomerVendor updateCustomerVendor(List<Customer> customers) {
        CustomerVendor customerVendor = customers.get(0).getCustomerVendor();
        if(customerVendor == null){
            throw new RuntimeException("No Customer Vendor to update");
        }
        else {
            customerVendor.setUpdated(new Date());
            customerVendor.setUpdatedBy("Admin");
            customerVendor.setCustomers(customers);
            customerVendor = customerVendorDAO.save(customerVendor);
            return customerVendor;
        }
    }

    private CustomerVendor createCustomerVendor(CreateCustomerRequest request, List<Customer> customers) {
        CustomerVendor customerVendor = new CustomerVendor();
        customerVendor.setCreated(new Date());
        customerVendor.setUpdated(new Date());
        customerVendor.setUpdatedBy("Admin");
        customerVendor.setCustomers(customers);
        customerVendor = customerVendorDAO.save(customerVendor);
        log.info("CustomerVendor saved successfully");
        return customerVendor;
    }

    private void validateRequestBody(CreateCustomerRequest request) {
        if(request.getEmailAddress() == null){
            throw new RuntimeException("Email Id cant be null");
        }
        else if(request.getPhoneNumber() == null){
            throw new RuntimeException("Phone number cant be null");
        }
        else if(request.getName() == null){
            throw new RuntimeException("Customer name cant not be null");
        }
    }
}
