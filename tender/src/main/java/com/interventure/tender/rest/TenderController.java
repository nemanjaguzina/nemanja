package com.interventure.tender.rest;

import com.interventure.tender.service.TenderCreationModel;
import com.interventure.tender.service.TenderService;
import com.interventure.tender.service.dto.TenderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tender")
public class TenderController {

    private TenderService tenderService;

    public TenderController(TenderService tenderService) {
        this.tenderService = tenderService;
    }

    @RequestMapping("/{userId}")
    public List<TenderDto> getAllUserOffers(@PathVariable("userId") Long userId) {
        return tenderService.getUserTenders(userId);
    }

    @RequestMapping(value = "/{userId}/new", method = RequestMethod.POST)
    public TenderDto submitNewTender(@PathVariable("userId") Long userId, @RequestBody TenderCreationModel tenderDto) {
        return tenderService.createTender(tenderDto);
    }
}
