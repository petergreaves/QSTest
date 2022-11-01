package com.example.qstest.service;

import com.example.qstest.model.Customer;
import lombok.RequiredArgsConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryBuilderServiceImpl implements QueryBuilderService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public CriteriaQuery getQueryFromQueryString(String qs) {

        final List<NameValuePair> params =
                URLEncodedUtils.parse(qs, StandardCharsets.UTF_8);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> customer = cq.from(Customer.class);
        List<Predicate> predicates = new ArrayList<>();

        for (final NameValuePair param : params) {
            predicates.add(cb.like(customer.get(param.getName()), param.getValue()));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return cq;
    }
}
