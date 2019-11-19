package com.interventure.tender.service.impl;

import com.interventure.tender.crudbase.DefaultBaseSearchService;
import com.interventure.tender.entity.Offer;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferSearchService extends DefaultBaseSearchService<Offer, OfferFilter, OfferSpec, OfferRepository> {
    protected OfferSearchService(OfferRepository repository, OfferSpec spec, DozerBeanMapper dozerBeanMapper) {
        super(repository, spec, dozerBeanMapper);
    }
}
