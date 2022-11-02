package com.example.qstest.service;

import com.example.qstest.model.Customer;

import javax.persistence.criteria.CriteriaQuery;

public interface QueryBuilderService {

    CriteriaQuery<Customer> getQueryFromQueryString(String qs);

}
