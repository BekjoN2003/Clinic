package com.example.exam.controller;

import com.example.exam.dto.VisitDTO;
import com.example.exam.model.Visit;
import com.example.exam.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/visit")
public class VisitController {
    private VisitService visitService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid VisitDTO dto){
        Visit result = visitService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        Visit result = visitService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid VisitDTO dto){
        Visit result = visitService.update(id, dto);
       return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        Visit result = visitService.delete(id);
        return ResponseEntity.ok(result);
    }
}
