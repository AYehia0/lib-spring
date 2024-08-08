package com.lib.api.Borrow;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Borrow(
        @Id Integer id,
        Integer patron_id,
        Integer book_id,
        LocalDate borrowing_date,
        LocalDate return_date,
        Integer copies
) {
}
