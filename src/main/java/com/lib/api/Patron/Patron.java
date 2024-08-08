package com.lib.api.Patron;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record Patron(
        @Id Integer id,
        @NotEmpty String name,
        @NotEmpty String email,
        @NotEmpty String password
) {
}
