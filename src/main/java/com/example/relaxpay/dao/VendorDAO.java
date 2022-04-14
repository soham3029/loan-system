package com.example.relaxpay.dao;

import com.example.relaxpay.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorDAO extends JpaRepository<Vendor, Integer> {

    @Query("select vd from Vendor vd where vd.vendorId = :vendorId")
    Vendor getVendorByVendorId(@Param("vendorId") String vendorID);
}
