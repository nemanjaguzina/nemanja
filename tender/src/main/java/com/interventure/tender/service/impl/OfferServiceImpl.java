package com.interventure.tender.service.impl;

import com.interventure.tender.entity.ApplicationUser;
import com.interventure.tender.entity.Offer;
import com.interventure.tender.entity.OfferStatus;
import com.interventure.tender.entity.Tender;
import com.interventure.tender.service.OfferCreationModel;
import com.interventure.tender.service.OfferService;
import com.interventure.tender.service.dto.OfferDto;
import com.interventure.tender.service.exception.BusinessException;
import com.interventure.tender.service.exception.EntityNotFoundException;
import com.interventure.tender.service.exception.WrongStatusException;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {
    public static final Logger LOGGER = LoggerFactory.getLogger(OfferService.class);
    private OfferRepository offerRepository;
    private TenderRepository tenderRepository;
    private BidderRepository bidderRepository;
    private OfferSearchService offerSearchService;
    private DozerBeanMapper dozerBeanMapper;

    public OfferServiceImpl(OfferRepository offerRepository, TenderRepository tenderRepository, BidderRepository bidderRepository, OfferSearchService offerSearchService, DozerBeanMapper dozerBeanMapper) {
        this.offerRepository = offerRepository;
        this.tenderRepository = tenderRepository;
        this.bidderRepository = bidderRepository;
        this.offerSearchService = offerSearchService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @Override
    public OfferDto addOffer(OfferCreationModel offerCreationModel) {
        Tender tender = tenderRepository.getOne(offerCreationModel.getTenderId());
        ApplicationUser bidder = bidderRepository.findById(offerCreationModel.getBidderId()).orElse(null);
        Offer entity = new Offer();
        entity.setTender(tender);
        entity.setStatus(OfferStatus.ACTIVE);
        entity.setCreatedBy(bidder);
        entity.setAmount(offerCreationModel.getAmount());
        entity.setCurrency(offerCreationModel.getCurrency());
        return dozerBeanMapper.map(offerRepository.save(entity), OfferDto.class);
    }

    @Override
    public boolean acceptOffer(Long offerId) throws BusinessException {
        Optional<Offer> offerOptional = offerRepository.findById(offerId);
        if (!offerOptional.isPresent()) {
            throw new EntityNotFoundException();
        }
        Offer offer = offerOptional.get();
        Tender tender = offer.getTender();
        tender.getOffers().forEach(o -> o.setStatus(OfferStatus.REJECTED));
        offer.setStatus(OfferStatus.ACCEPTED);
        tenderRepository.save(tender);
        return true;
    }

    @Override
    public boolean rejectOffer(Long offerId) throws BusinessException {
        Optional<Offer> optionalOffer = offerRepository.findById(offerId);
        if (!optionalOffer.isPresent()) {
            throw new EntityNotFoundException();
        }

        Offer offer = optionalOffer.get();
        if (offer.getStatus() != OfferStatus.ACTIVE) {
            throw new WrongStatusException();
        }
        offer.setStatus(OfferStatus.REJECTED);
        offerRepository.save(offer);
        return true;
    }

    @Override
    public List<OfferDto> getOfferForTender(Long tenderId) {
        OfferFilter offerFilter = new OfferFilter();
        offerFilter.setTenderId(tenderId);
        return offerSearchService.findAllAndConvert(offerFilter, OfferDto.class);
    }

    @Override
    public List<OfferDto> getUserOffers(Long userId) {
        OfferFilter offerFilter = new OfferFilter();
        offerFilter.setUserId(userId);
        return offerSearchService.findAllAndConvert(offerFilter, OfferDto.class);
    }

    @Override
    public List<OfferDto> getUserOffersForTender(Long userId, Long tenderId) {
        OfferFilter offerFilter = new OfferFilter();
        offerFilter.setUserId(userId);
        offerFilter.setTenderId(tenderId);
        return offerSearchService.findAllAndConvert(offerFilter, OfferDto.class);
    }
}
