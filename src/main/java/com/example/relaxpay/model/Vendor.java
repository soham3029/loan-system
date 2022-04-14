package com.example.relaxpay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendor", catalog = "rps")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "vendor_reference_id")
    private String vendorId;
    @Column(name = "vendor_name" , nullable = false)
    private String vendorName;
    @Column(name = "pan_card_number", nullable = false)
    private String panCardNumber;
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "address_line1")
    private String addressLine1;
    @Column(name = "address_line2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "amount_to_be_received")
    private BigDecimal amountToBeReceived;
    @Column(name = "state")
    private String state;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private CustomerVendor vendor;

}
