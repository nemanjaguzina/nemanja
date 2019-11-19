package com.interventure.tender.service;

import com.interventure.tender.entity.Tender;

public interface TenderCreationService {
    Tender createTender(TenderCreationModel creationModel);
}
