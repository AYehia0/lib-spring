package com.lib.api.Patron;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatronNotFoundException extends RuntimeException {
    public PatronNotFoundException() {
        super("Patron not found");
    }
}
