package com.interventure.tender.service.impl;

import com.interventure.tender.crudbase.DefaultBaseSearchService;
import com.interventure.tender.entity.Tender;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class TenderSearchService extends DefaultBaseSearchService<Tender, TenderFilter, TenderSpec, TenderRepository> {
    protected TenderSearchService(TenderRepository repository, TenderSpec spec, DozerBeanMapper dozerBeanMapper) {
        super(repository, spec, dozerBeanMapper);
    }
}
