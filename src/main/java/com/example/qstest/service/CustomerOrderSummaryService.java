package com.example.qstest.service;

import com.example.qstest.cache.CustomerOrdersSummary;

public interface CustomerOrderSummaryService {

    CustomerOrdersSummary getOrdersSummaryForCustomer(Long customerID);
}
