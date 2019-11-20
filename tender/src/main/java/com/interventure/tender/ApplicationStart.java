package com.interventure.tender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Starts the spring boot application.
 */
@EnableJpaRepositories
@SpringBootApplication
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class, ApplicationStart.class})
@EnableTransactionManagement
public class ApplicationStart extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("Starting Tender application...");
        SpringApplication.run(ApplicationStart.class, args);
        System.out.println("Tender application started");
    }

}
