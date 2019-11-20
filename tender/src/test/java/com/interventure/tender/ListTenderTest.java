package com.interventure.tender;

import com.interventure.tender.service.TenderCreationModel;
import com.interventure.tender.service.TenderService;
import com.interventure.tender.service.dto.TenderDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ListTenderTest {
    @Autowired
    private TenderService tenderService;

    @Test
    public void listTenderTest() {
        List<TenderDto> tenders = tenderService.getUserTenders(1L);
        Assert.assertEquals(tenders.size(), 2);
    }
}
