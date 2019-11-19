package com.interventure.tender.service;

import com.interventure.tender.service.dto.TenderDto;

import java.util.List;

public interface TenderService {
    List<TenderDto> getUserTenders(Long userId);

    TenderDto createTender(TenderCreationModel creationModel);
}
