package com.interventure.tender.service.impl;

import com.interventure.tender.crudbase.BaseFilter;

public class TenderFilter extends BaseFilter {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
