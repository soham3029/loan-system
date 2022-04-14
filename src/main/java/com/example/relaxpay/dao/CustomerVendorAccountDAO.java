package com.example.relaxpay.dao;

import com.example.relaxpay.model.CustomerVendorAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerVendorAccountDAO extends JpaRepository<CustomerVendorAccount, Integer> {
    @Query("select ac from CustomerVendorAccount ac join ac.customer acc join ac.vendor acv where acc.customerId in (:customerIds) and acv.vendorId in (:vendorIds)")
    public List<CustomerVendorAccount> fetchAccountDetails(@Param("customerIds") List<String> customerIds, @Param("vendorIds") List<String> vendorIds);
}
