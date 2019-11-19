package com.interventure.tender.service;

import com.interventure.tender.entity.Offer;
import com.interventure.tender.service.dto.OfferDto;
import com.interventure.tender.service.exception.BusinessException;
import com.interventure.tender.service.exception.EntityNotFoundException;

import java.util.List;

public interface OfferService {
    Offer addOffer(OfferCreationModel offerCreationModel);

    boolean acceptOffer(Long offerId) throws BusinessException;

    boolean rejectOffer(Long offerId) throws BusinessException;

    List<OfferDto> getOfferForTender(Long tenderId);

    List<OfferDto> getUserOffers(Long userId);

    List<OfferDto> getUserOffersForTender(Long userId, Long tenderId);
}
