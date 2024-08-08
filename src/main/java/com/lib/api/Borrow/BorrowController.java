package com.lib.api.Borrow;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
● Borrowing endpoints:
    ● POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book.
    ● PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.
*/

@RestController
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/api/borrow/{bookId}/patron/{patronId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void borrowBook(@PathVariable Integer bookId, @PathVariable Integer patronId) {
        borrowService.borrowBook(bookId, patronId);
    }

    @PutMapping("/api/return/{bookId}/patron/{patronId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnBook(@PathVariable Integer bookId, @PathVariable Integer patronId) {
        borrowService.returnBook(bookId, patronId);
    }

}
