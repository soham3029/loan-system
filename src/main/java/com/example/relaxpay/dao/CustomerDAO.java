package com.example.relaxpay.dao;

import com.example.relaxpay.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.customerId = :customerId")
    Customer getByCustomerId(@Param("customerId") String customerId);
}
