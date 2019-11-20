package com.interventure.tender.rest;

import com.interventure.tender.entity.Offer;
import com.interventure.tender.entity.OfferStatus;
import com.interventure.tender.entity.Tender;
import com.interventure.tender.service.impl.OfferFilter;
import com.interventure.tender.service.impl.OfferSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddOfferRestTest {
    private static final String JSON_REQUEST = "{\n" +
            "\t\"amount\":1.4,\n" +
            "\t\"currency\": \"EUR\"\n" +
            "}";
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private OfferSearchService offerSearchService;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void addTenderTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/offer/1/1").content(JSON_REQUEST).contentType(MediaType.APPLICATION_JSON));

        OfferFilter filter = new OfferFilter();
        filter.setTenderId(2L);
        filter.setUserId(1L);
        List<Offer> offers = offerSearchService.findAll(filter);
        Assert.assertEquals(3, offers.size());
        Assert.assertTrue(offers.get(2).getCurrency().equalsIgnoreCase("EUR"));
        Assert.assertEquals(0, offers.get(2).getAmount().compareTo(new BigDecimal(1.4)));
        Assert.assertSame(offers.get(2).getStatus(), OfferStatus.ACTIVE);

    }

}