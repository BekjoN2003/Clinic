package com.example.exam.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PatientDto {
    private Integer id;
    @NotEmpty(message = "Hey name must be not empty")
    @NotNull(message = "Hey name must be not null")
    private String name;
    @NotEmpty(message = "Hey surname must be not empty")
    @NotNull(message = "Hey surname must be not null")
    @Size(min = 4, message = "Size must be...")
    private String surname;
    private LocalDate birthday;
    @NotBlank(message = ("..."))
    private String contact;

    private Integer age;
    private Boolean status;
    private LocalDateTime createdAt;



}
