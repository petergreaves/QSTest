package com.example.qstest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Data
public class CustomerOrdersSummary {
    private Long customerID;
    private Integer orderCount;
    private BigDecimal totalValue;
}
