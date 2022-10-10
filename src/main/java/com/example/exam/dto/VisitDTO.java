package com.example.exam.dto;

import com.example.exam.model.Doctor;
import com.example.exam.model.Patient;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class VisitDTO {
    private Integer id;
    @NotBlank(message = "...")
    private Patient patient;
    private Integer patientId;
    private Doctor doctor;
    private Integer doctorId;
    private String diagnosis;
    private Boolean status;
    private LocalDateTime createdAt;
}
