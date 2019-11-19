package com.interventure.tender.service.impl;

import com.interventure.tender.crudbase.BaseFilter;
import com.interventure.tender.entity.OfferStatus;

public class OfferFilter extends BaseFilter {
    private Long tenderId;
    private Long userId;
    private OfferStatus status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTenderId() {
        return tenderId;
    }

    public void setTenderId(Long tenderId) {
        this.tenderId = tenderId;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }
}
