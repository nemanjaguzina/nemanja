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
public class ListTenderRestTest {
    private static final String EXPECTED_REPONSE = "[{\"id\":1,\"tenderName\":\"TestTender\",\"description\":\"This is a test decription\"}," +
            "{\"id\":2,\"tenderName\":\"TestTender1\",\"description\":\"This is a test decription1\"}]";
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
    public void listTenderTest() throws Exception {
        ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/tender/1"));
        String resultContent = perform.andReturn().getResponse().getContentAsString();

        Assert.assertEquals(EXPECTED_REPONSE, resultContent);
    }

}