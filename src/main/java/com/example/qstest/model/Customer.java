package com.example.qstest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CUSTOMER")
public class Customer {

    @Id
    private Long id;

    @Column(name="CUSTOMER_NAME")
    private String name;

    @Column(name="ACC_NUMBER")
    private String accountNumber;

    @Column(name="CITY")
    private String city;

    @Column(name="CREDIT_LIMIT")
    private BigDecimal creditLimit;

}
