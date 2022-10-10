package com.example.exam.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class DoctorDTO {

    private Integer id;

    @NotEmpty(message = "...")
    @NotNull(message = "...")
    private String name;

    @NotBlank(message = "...")
    private String surname;

    @NotBlank(message = "...")
    private String direction;

    @NotBlank(message = "...")
    private String contact;

    private Integer experience;

    private Boolean status;

    private LocalDateTime createdAt;
}
