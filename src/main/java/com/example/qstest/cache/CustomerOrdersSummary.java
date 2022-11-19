package com.example.qstest.cache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Data
public class CustomerOrdersSummary {
    private Integer orderCount;
    private BigDecimal totalValue;
}
