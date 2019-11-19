package com.interventure.tender.service.exception;

public class EntityNotFoundException extends BaseErrorCodeException {
    public EntityNotFoundException() {
        super("1001", "Entity not found in database");
    }
}
