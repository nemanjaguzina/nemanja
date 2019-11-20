package com.interventure.tender.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfferRestTest {
    private static final String EXPECTED_REPONSE = "[{\"id\":1,\"amount\":1.40,\"currency\":\"EUR\"}," +
            "{\"id\":2,\"amount\":1.40,\"currency\":\"EUR\"},{\"id\":3,\"amount\":1.40,\"currency\":\"EUR\"}]";
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void listOfferTest() throws Exception {
        ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/offer/1"));
        String resultContent = perform.andReturn().getResponse().getContentAsString();

        Assert.assertEquals(EXPECTED_REPONSE, resultContent);
    }

}
