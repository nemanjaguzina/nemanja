package com.interventure.tender.rest;

import com.interventure.tender.service.OfferCreationModel;
import com.interventure.tender.service.OfferService;
import com.interventure.tender.service.dto.OfferDto;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{tenderId}/{userId}/new", method = RequestMethod.POST)
    public OfferDto submitOffer(@PathVariable("tenderId") Long tenderId, @PathVariable("userId") Long userId, @RequestBody OfferCreationModel offerCreationModel) {
        offerCreationModel.setBidderId(userId);
        offerCreationModel.setTenderId(tenderId);
        return offerService.addOffer(offerCreationModel);
    }

}
