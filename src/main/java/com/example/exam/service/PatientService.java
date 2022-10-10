package com.example.exam.service;

import com.example.exam.model.Patient;
import com.example.exam.dto.PatientDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import com.example.exam.exception.BadRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import com.example.exam.repository.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.LinkedList;
import java.time.LocalDateTime;

@Service
@Component
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    public Patient create(PatientDto dto) {
        Patient patient = new Patient();
        convertToEntity(patient, dto);
        patient.setCreatedAt(LocalDateTime.now());
        patient.setStatus(true);
        patientRepository.save(patient);
        return patient;
    }

    public Patient get(Integer id) {
        return getEntity(id);
    }

    public Patient update(Integer id, PatientDto patientDto) {
        Patient oldPatent = getEntity(id);
        convertToEntity(oldPatent, patientDto);
        oldPatent.setUpdatedAt(LocalDateTime.now());
        patientRepository.save(oldPatent);
        return oldPatent;
    }

    public Patient delete(Integer id) {
        Patient patient = getEntity(id);
        patient.setDeletedAt(LocalDateTime.now());
        patientRepository.delete(patient);
        return patient;
    }

    public List<Patient> getAll(Integer size, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Patient> patientPage = patientRepository.findAll(pageRequest);
        List<Patient> patientList = new LinkedList<>();
        for (Patient p : patientPage) {
            patientList.add(p);
        }
        return patientList;
    }

    public Patient getEntity(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }

    private void convertToEntity(Patient patient, PatientDto patientDTO) {
        patient.setBirthday(patientDTO.getBirthday());
        patient.setContact(patientDTO.getContact());
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setAge(patientDTO.getAge());
    }

}
