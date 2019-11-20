package com.interventure.tender.service;

import com.interventure.tender.service.dto.OfferDto;
import com.interventure.tender.service.exception.BusinessException;

import java.util.List;

public interface OfferService {

    /*adds an offer to specific tender.*/
    OfferDto addOffer(OfferCreationModel offerCreationModel);

    /*Marks offer as accepted and other offers within same tender as rejected*/
    boolean acceptOffer(Long offerId) throws BusinessException;

    /*Rejects offer*/
    boolean rejectOffer(Long offerId) throws BusinessException;

    /*Lists offer for specific tender*/
    List<OfferDto> getOfferForTender(Long tenderId);

    /*lists offer for specific user*/
    List<OfferDto> getUserOffers(Long userId);

    /*Lists offers from one tender for specific user and tender*/
    List<OfferDto> getUserOffersForTender(Long userId, Long tenderId);
}
