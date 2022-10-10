package com.example.exam.controller;

import com.example.exam.dto.DoctorDTO;
import com.example.exam.model.Doctor;
import com.example.exam.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid DoctorDTO doctorDTO){
        Doctor result = doctorService.create(doctorDTO);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        Doctor result = doctorService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid DoctorDTO dto){
        Doctor result = doctorService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        Doctor result  = doctorService.delete(id);
        return ResponseEntity.ok(result);
    }

}


