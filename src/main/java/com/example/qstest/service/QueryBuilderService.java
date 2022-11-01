package com.example.qstest.service;

import javax.persistence.criteria.CriteriaQuery;

public interface QueryBuilderService {

    CriteriaQuery getQueryFromQueryString(String qs);

}
