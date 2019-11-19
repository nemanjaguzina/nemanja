package com.interventure.tender.crudbase;


import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class BaseSpec<T extends BaseEntity, F extends BaseFilter> {

    protected abstract void addPredicatesToList(F filter, Root<T> root, CriteriaQuery query, CriteriaBuilder cb, List<Predicate> predicates);

    /**
     * adds predicate produced by predicateSupplier to predicates if filterValue is not null
     *
     * @param predicates        list of predicates
     * @param filterValue       value to check for non-null
     * @param predicateSupplier supplier function
     */
    protected void addIfNotNull(List<Predicate> predicates, Object filterValue, Supplier<Predicate> predicateSupplier) {
        if (filterValue != null) {
            addToPredicates(predicates, predicateSupplier);
        }
    }

    /**
     * adds predicate produced by predicateSupplier to predicates if filterValue is null
     *
     * @param predicates        list of predicates
     * @param filterValue       value to check for null
     * @param predicateSupplier supplier function
     */
    protected void addIfNull(List<Predicate> predicates, Object filterValue, Supplier<Predicate> predicateSupplier) {
        if (filterValue == null) {
            addToPredicates(predicates, predicateSupplier);
        }
    }

    /**
     * adds predicate produced by predicateSupplier to predicates if filterValue is {@code true}
     *
     * @param predicates        list of predicates
     * @param filterValue       value to check for true
     * @param predicateSupplier supplier function
     */
    protected void addIfTrue(List<Predicate> predicates, Boolean filterValue, Supplier<Predicate> predicateSupplier) {
        if (Boolean.TRUE.equals(filterValue)) {
            addToPredicates(predicates, predicateSupplier);
        }
    }

    Specification<T> build(F filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new LinkedList<>();

            addPredicatesToList(filter, root, query, cb, predicates);

            Optional<Boolean> distinct = isDistinct();
            distinct.ifPresent(query::distinct);

            return cb.and(toArray(predicates));
        };
    }

    private Optional<Boolean> isDistinct() {
        return Optional.empty();
    }

    private void addToPredicates(List<Predicate> predicates, Supplier<Predicate> predicateSupplier) {
        Predicate p = predicateSupplier.get();
        predicates.add(p);
    }

    private Predicate[] toArray(List<Predicate> predicates) {
        return predicates.toArray(new Predicate[0]);
    }
}
