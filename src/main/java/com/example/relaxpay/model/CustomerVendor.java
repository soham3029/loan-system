package com.example.relaxpay.model;

import com.example.relaxpay.constants.CustomerOrVendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_vendor", catalog = "rps")
public class CustomerVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private CustomerOrVendor type;
    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Customer> customers;
    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Vendor> vendors;
}
