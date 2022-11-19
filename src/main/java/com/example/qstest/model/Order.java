package com.example.qstest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ORDERS")
public class Order {

    @Id
    @Column(name="ORDER_ID")
    private Long id;

    @Column(name="ORD_VALUE")
    private Double orderValue;

    @Column(name="CUSTOMER_ID")
    private Long customerID;

}
