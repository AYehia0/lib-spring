package com.lib.api.Borrow;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Borrow(
        @Id Integer id,
        Integer patron_id,
        Integer book_id,
        LocalDate borrowing_date,
        LocalDate return_date,
        Integer copies
) {
}
