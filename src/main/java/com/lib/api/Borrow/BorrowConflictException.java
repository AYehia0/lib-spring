package com.lib.api.Borrow;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BorrowConflictException extends RuntimeException {
    public BorrowConflictException() {
        super("Book has not been borrowed by the patron or has already been returned.");
    }
}
