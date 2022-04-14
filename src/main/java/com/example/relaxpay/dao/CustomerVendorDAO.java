package com.example.relaxpay.dao;

import com.example.relaxpay.model.CustomerVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerVendorDAO extends JpaRepository<CustomerVendor, Integer> {
}
