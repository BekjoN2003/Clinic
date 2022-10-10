package com.example.exam.controller;

import com.example.exam.dto.PatientDto;
import com.example.exam.model.Patient;
import com.example.exam.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private  PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<?> createPatient(@RequestBody @Valid PatientDto patient) {
        Patient result = patientService.create(patient);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPatient(@PathVariable("id") Integer id) {
        Patient result = patientService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable("id") Integer id, @RequestBody @Valid PatientDto dto) {
        Patient result = patientService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Integer id) {
        Patient result = patientService.delete(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPatient(@RequestParam("s") Integer size,
                                    @RequestParam("p") Integer page) {
        List<Patient> result = patientService.getAll(size, page);
        return ResponseEntity.ok(result);
    }

}
