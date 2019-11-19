package com.interventure.tender.service.exception;

import java.net.URL;

public class WrongStatusException extends BaseErrorCodeException {
    public WrongStatusException() {
        super("1002", "Object is in wrong status for current action");
    }
}
