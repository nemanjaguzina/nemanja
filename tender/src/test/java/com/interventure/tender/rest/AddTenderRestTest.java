package com.interventure.tender.rest;

import com.interventure.tender.entity.Tender;
import com.interventure.tender.service.impl.TenderSearchService;
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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddTenderRestTest {
    private static final String JSON_REQUEST = "{\n" +
            "\"tenderName\":\"Test tender\",\n" +
            "\"description\": \"Test description\"\n" +
            "}";
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private TenderSearchService tenderSearchService;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void addTenderTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/tender/1/new").content(JSON_REQUEST).contentType(MediaType.APPLICATION_JSON));

        List<Tender> tenders = tenderSearchService.findAll();
        Assert.assertEquals(tenders.size(), 3);
        Assert.assertTrue(tenders.get(2).getTenderName().equalsIgnoreCase("Test tender"));

    }

}