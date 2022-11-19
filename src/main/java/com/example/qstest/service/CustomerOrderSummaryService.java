package com.example.qstest.service;

import com.example.qstest.model.CustomerOrdersSummary;

import java.util.Optional;

public interface CustomerOrderSummaryService {

    CustomerOrdersSummary getOrdersSummaryForCustomer(Long customerID);
}
