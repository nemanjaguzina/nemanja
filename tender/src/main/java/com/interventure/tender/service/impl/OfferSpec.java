package com.interventure.tender.service.impl;

import com.interventure.tender.crudbase.BaseSpec;
import com.interventure.tender.entity.Offer;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class OfferSpec extends BaseSpec<Offer, OfferFilter> {
    @Override
    protected void addPredicatesToList(OfferFilter filter, Root<Offer> root, CriteriaQuery query, CriteriaBuilder cb, List<Predicate> predicates) {
        addIfNotNull(predicates, filter.getTenderId(),
                () -> cb.equal(root.get("tender").get("id"), filter.getTenderId()));
        addIfNotNull(predicates, filter.getUserId(),
                () -> cb.equal(root.get("createdBy").get("id"), filter.getUserId()));
        addIfNotNull(predicates, filter.getStatus(),
                () -> cb.equal(root.get("status"), filter.getStatus()));
    }
}
