package com.example.relaxpay.model;

import com.example.relaxpay.constants.CustomerOrVendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "customer_vendor_account", catalog = "rps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVendorAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "customer_vendor_relation_ship_id")
    private String customerVendorRelationShipId;
    @Column(name = "customer_account_number")
    private String customerAccountNumber;
    @Column(name = "vendor_account_number")
    private String vendorAccountNumber;
    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;
    @Column(name = "pending_amount")
    private BigDecimal pendingAmount;
    @Column(name = "transaction_purpose")
    private String transactionPurpose;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_if_transaction")
    private Date dateOfTransaction;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Vendor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
}
