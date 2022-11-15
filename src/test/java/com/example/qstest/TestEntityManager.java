package com.example.qstest;

import com.example.qstest.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class TestEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(entityManager);
    }

    @Test
    public void testCriteriaBuilderBasic(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> customer = cq.from(Customer.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.like(customer.get("name"), "%a%"));
        cq.where(predicates.toArray(new Predicate[0]));

        List<Customer> results = entityManager.createQuery(cq).getResultList();
        Assertions.assertEquals(results.size(),2);

    }


}
