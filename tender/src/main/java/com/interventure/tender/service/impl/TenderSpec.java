package com.interventure.tender.service.impl;

import com.interventure.tender.crudbase.BaseSpec;
import com.interventure.tender.entity.Tender;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class TenderSpec extends BaseSpec<Tender, TenderFilter> {
    @Override
    protected void addPredicatesToList(TenderFilter filter, Root<Tender> root, CriteriaQuery query, CriteriaBuilder cb, List<Predicate> predicates) {
        addIfNotNull(predicates, filter.getId(),
                () -> cb.equal(root.get("id"), filter.getId()));
        addIfNotNull(predicates, filter.getUserId(),
                () -> cb.equal(root.get("createdBy").get("id"), filter.getUserId()));
    }
}
