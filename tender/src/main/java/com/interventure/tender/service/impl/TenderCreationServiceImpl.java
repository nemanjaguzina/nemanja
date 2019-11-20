package com.interventure.tender.service.impl;

import com.interventure.tender.entity.Tender;
import com.interventure.tender.service.TenderCreationModel;
import com.interventure.tender.service.TenderCreationService;
import org.springframework.stereotype.Service;

@Service
public class TenderCreationServiceImpl implements TenderCreationService {

    private TenderRepository tenderRepository;

    public TenderCreationServiceImpl(TenderRepository tenderRepository) {
        this.tenderRepository = tenderRepository;
    }

    @Override
    public Tender createTender(TenderCreationModel creationModel) {
        Tender tender = new Tender();
        tender.setTenderName(creationModel.getTenderName());
        tender.setDescription(creationModel.getDescription());
        return tenderRepository.save(tender);
    }
}
