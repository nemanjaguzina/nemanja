package com.interventure.tender.service.impl;

import com.interventure.tender.entity.Tender;
import com.interventure.tender.service.TenderCreationModel;
import com.interventure.tender.service.TenderCreationService;
import com.interventure.tender.service.TenderService;
import com.interventure.tender.service.dto.TenderDto;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenderServiceImpl implements TenderService {
    private TenderSearchService tenderSearchService;
    private TenderCreationService tenderCreationService;
    private DozerBeanMapper dozerBeanMapper;

    public TenderServiceImpl(TenderSearchService tenderSearchService, TenderCreationService tenderCreationService, DozerBeanMapper dozerBeanMapper) {
        this.tenderSearchService = tenderSearchService;
        this.tenderCreationService = tenderCreationService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @Override
    public List<TenderDto> getUserTenders(Long userId) {
        return tenderSearchService.findAllAndConvert(new TenderFilter(), TenderDto.class);
    }

    @Override
    public TenderDto createTender(TenderCreationModel creationModel) {
        Tender tender = tenderCreationService.createTender(creationModel);
        return dozerBeanMapper.map(tender, TenderDto.class);
    }
}
