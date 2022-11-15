package com.example.qstest;


import com.example.qstest.beans.SupportedParams;
import com.example.qstest.model.Customer;
import com.example.qstest.service.QueryBuilderService;
import com.example.qstest.service.QueryBuilderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@SpringBootTest
@Slf4j
@TestPropertySource("classpath:application-test.properties")
public class TestQueryStringParser {

    private String qs = null;


    @PersistenceContext
    private EntityManager entityManager;

    private QueryBuilderService queryBuilderService ;

    @Autowired
    private SupportedParams supportedParams;

    @BeforeEach
    public void setup() {
        queryBuilderService = new QueryBuilderServiceImpl(supportedParams, entityManager) ;
    }

    @Test
    public void testEmptyStringQSSReturns4(){

        qs = "";
        CriteriaQuery<Customer> query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),6);
    }

    @Test
    public void testUnsupportedQueryStringIsIgnoredAndReturns4(){

        qs = "foo=bar";
        CriteriaQuery<Customer> query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),6);
    }

    @Test
    public void testNullQSSReturns4(){

        qs = null;
        CriteriaQuery<Customer> query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),6);
    }

    @Test
    public void testMultiValuedQSReturns1(){

        qs = "city=London&creditLimit=1000";
        CriteriaQuery<Customer> query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),2);
    }

    @Test
    public void testMultiValuedQSReturnsEmptyList(){

        qs = "creditLimit=1000000";
        CriteriaQuery<Customer> query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),0);
    }




    @Test
    public void testOneResultFound(){
        qs = "accountNumber=AC004";
        CriteriaQuery<Customer> query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),1);

    }

}
