package com.everton.springboot2.requests;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot be null or empty")
    private String name;
}
