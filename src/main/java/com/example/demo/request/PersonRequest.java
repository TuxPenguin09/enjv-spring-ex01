package com.example.demo.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    private Long id;

    @NotBlank(message = "First name can't not be blank!")
    private String firstName;

    @NotBlank(message = "Last name can't not be blank!")
    private String lastName;

    private LocalDateTime birthDate;

    private String section;
}
