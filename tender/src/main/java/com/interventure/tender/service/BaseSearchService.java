package com.interventure.tender.service;

import java.util.List;

public interface BaseSearchService<E, F> {
    List<E> findAll(F filter);
}
