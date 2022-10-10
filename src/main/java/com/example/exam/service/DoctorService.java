package com.example.exam.service;

import com.example.exam.dto.DoctorDTO;
import com.example.exam.exception.BadRequest;
import com.example.exam.model.Doctor;
import com.example.exam.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@Component
@AllArgsConstructor
public class DoctorService {


    private DoctorRepository doctorRepository;

    public Doctor get(Integer id) {
        return getEntity(id);
    }

    public Doctor create(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        convertToEntity(doctor,dto);
        doctor.setCreatedAt(LocalDateTime.now());
        doctor.setStatus(true);
        doctorRepository.save(doctor);
        return doctor;
    }


    public Doctor update(Integer id, DoctorDTO dto) {
        Doctor doctor1 = getEntity(id);
        convertToEntity(doctor1,dto);
        doctorRepository.save(doctor1);
        return doctor1;
    }
    private void convertToEntity(Doctor doctor1, DoctorDTO dto){
        doctor1.setName(dto.getName());
        doctor1.setSurname(dto.getSurname());
        doctor1.setContact(dto.getContact());
        doctor1.setDirection(dto.getDirection());
    }

    public Doctor delete(Integer id) {
        Doctor doctor = getEntity(id);
        doctorRepository.save(doctor);
        return doctor;
    }

    public Doctor getEntity(Integer id) {
        Optional<Doctor> optional =doctorRepository.findById(id);
        if(optional.isEmpty()){
            throw new BadRequest("Doctor not fount");
        }
        return optional.get();
    }




}
