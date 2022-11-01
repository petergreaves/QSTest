package com.example.qstest;


import com.example.qstest.model.Customer;
import com.example.qstest.service.QueryBuilderService;
import com.example.qstest.service.QueryBuilderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@DataJpaTest
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
    public void testOneResultFound(){
        qs = "accountNumber=AC003";
        CriteriaQuery query = queryBuilderService.getQueryFromQueryString(qs);
        List<Customer> results = entityManager.createQuery(query).getResultList();
        Assertions.assertEquals(results.size(),1);

    }

}
