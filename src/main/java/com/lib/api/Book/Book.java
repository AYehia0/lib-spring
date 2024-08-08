package com.lib.api.Book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Book(
        @NotEmpty String title,
        @NotEmpty String author,
        String isbn,
        @NotNull Integer publication_year,
        @Positive Integer copies
) {
}
