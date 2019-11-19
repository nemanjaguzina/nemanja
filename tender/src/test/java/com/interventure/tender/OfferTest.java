package com.interventure.tender;

import com.interventure.tender.entity.Offer;
import com.interventure.tender.entity.OfferStatus;
import com.interventure.tender.entity.Tender;
import com.interventure.tender.service.OfferCreationModel;
import com.interventure.tender.service.OfferService;
import com.interventure.tender.service.dto.OfferDto;
import com.interventure.tender.service.exception.BusinessException;
import com.interventure.tender.service.impl.TenderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OfferTest {
    @Autowired
    private OfferService offerService;
    @Autowired
    private TenderRepository tenderRepository;

    @Test
    public void addOfferTest() {
        OfferCreationModel offerCreationModel = new OfferCreationModel();
        offerCreationModel.setTenderId(1L);
        offerCreationModel.setAmount(BigDecimal.TEN);
        offerCreationModel.setCurrency("EUR");
        offerCreationModel.setBidderId(1L);
        Offer offer = offerService.addOffer(offerCreationModel);

        Assert.assertNotNull(offer);
    }

    @Test
    public void acceptOfferTest() throws BusinessException {
        boolean success = offerService.acceptOffer(1L);
        Assert.assertTrue(success);
        Optional<Tender> tenderOptional = tenderRepository.findById(2L);
        Assert.assertTrue(tenderOptional.isPresent());
        Tender tender = tenderOptional.get();
        List<Offer> offers = tender.getOffers();
        Assert.assertEquals(offers.get(0).getStatus(), OfferStatus.ACCEPTED);
        Assert.assertEquals(offers.get(1).getStatus(), OfferStatus.REJECTED);
        Assert.assertEquals(offers.get(1).getStatus(), OfferStatus.REJECTED);

    }

    @Test
    public void findOffersForTender() {
        List<OfferDto> offerForTender = offerService.getOfferForTender(2L);
        Assert.assertEquals(3, offerForTender.size());
    }

    @Test
    public void findOffersForUser() {
        List<OfferDto> offerForTender = offerService.getUserOffers(1L);
        Assert.assertEquals(3, offerForTender.size());
    }

    @Test
    public void findOffersForUserAndTender() {
        List<OfferDto> offerForTender = offerService.getUserOffersForTender(1L, 2L);
        Assert.assertEquals(3, offerForTender.size());
    }
}
