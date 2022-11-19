package com.example.qstest.model;

import com.example.qstest.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CUSTOMERS")
public class Customer {


    @Id
    @Column(name="CUSTOMER_ID")
    private Long id;

    @Column(name="CUSTOMER_NAME")
    private String name;

    @Column(name="ACC_NUMBER")
    private String accountNumber;

    @Column(name="CITY")
    private String city;

    @Column(name="CREDIT_LIMIT")
    private Integer creditLimit;

    @Transient
    private Integer orderCount = 0;

    @Transient
    private BigDecimal ordersValue = new BigDecimal(0d);


}
