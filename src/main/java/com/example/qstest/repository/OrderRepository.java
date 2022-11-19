package com.example.qstest.repository;

import com.example.qstest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface OrderRepository extends JpaRepository<Order, Long> {

    int countByCustomerID(Long customerID);

    @Query("SELECT SUM(o.orderValue) FROM Order o where o.customerID = :custID")
    BigDecimal totalByCustomerID(@Param("custID") Long customerID);
}
