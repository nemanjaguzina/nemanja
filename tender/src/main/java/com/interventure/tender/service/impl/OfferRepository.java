package com.interventure.tender.service.impl;

import com.interventure.tender.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface OfferRepository extends JpaRepositoryImplementation<Offer, Long> {
}
