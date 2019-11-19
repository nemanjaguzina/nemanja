package com.interventure.tender.rest;

import com.interventure.tender.service.OfferService;
import com.interventure.tender.service.dto.OfferDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping("/{userId}")
    public List<OfferDto> getAllUserOffers(@PathVariable("userId") Long userId) {
        return offerService.getUserOffers(userId);
    }

    @RequestMapping("/{tenderId}/{userId}")
    public List<OfferDto> getAllUserTenderOffers(@PathVariable("tenderId") Long tenderId, @PathVariable("userId") Long userId) {
        return offerService.getUserOffersForTender(userId, tenderId);
    }

}
