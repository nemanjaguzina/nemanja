package com.interventure.tender.service.impl;

import com.interventure.tender.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface TenderRepository extends JpaRepositoryImplementation<Tender, Long> {
}
