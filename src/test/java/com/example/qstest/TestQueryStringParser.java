package com.example.qstest;


import com.example.qstest.model.Customer;
import com.example.qstest.service.QueryBuilderService;
import com.example.qstest.service.QueryBuilderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@DataJpaTest
@Slf4j
@TestPropertySource("classpath:application-test.properties")
public class TestQueryStringParser {

    private String qs = null;

    @PersistenceContext
    private EntityManager entityManager;

    private QueryBuilderService queryBuilderService ;

    @BeforeEach
    public void setup() {
        queryBuilderService = new QueryBuilderServiceImpl(entityManager);
    }


    @Test
    public void multiValuedQS(){

        qs = "city=London&creditLimit=1000";
        CriteriaQuery query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),1);
    }

    @Test
    public void testOneResultFound(){
        qs = "accountNumber=AC003";
        CriteriaQuery query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),1);

    }

}
