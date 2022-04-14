package com.example.relaxpay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", catalog = "rps")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "customer_reference_id")
    private String customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "pan_card_number")
    private String panCardNumber;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    @Column(name = "alternate_number")
    private String alternateNumber;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "state")
    private String state;
    @Column(name = "amount_to_be_transferred")
    private BigDecimal amountToBeTransferred;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;


    @ManyToOne
    @JoinColumn(name = "customer_vendor_id")
    private CustomerVendor customerVendor;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerVendor customer;

}
