package com.interventure.tender.service.impl;

import com.interventure.tender.entity.ApplicationUser;
import com.interventure.tender.entity.Offer;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface BidderRepository extends JpaRepositoryImplementation<ApplicationUser, Long> {
}
