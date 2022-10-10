package com.example.exam.service;

import com.example.exam.dto.VisitDTO;
import com.example.exam.exception.BadRequest;
import com.example.exam.model.Visit;
import com.example.exam.repository.VisitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@Component
@AllArgsConstructor
public class VisitService {

    private VisitRepository visitRepository;

    public Visit get(Integer id) {
        return getEntity(id);
    }

    public Visit getEntity(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Visit not found");
        }
        return optional.get();
    }

    public Visit create(VisitDTO dto) {
        Visit visit = new Visit();
        convertToEntity(visit, dto);
        visit.setStatus(true);
        visit.setCreatedAt(LocalDateTime.now());
        return visit;
    }

    public Visit update(Integer id, VisitDTO dto) {
        Visit oldVisit = getEntity(id);
        convertToEntity(oldVisit,dto);
        visitRepository.save(oldVisit);
        return oldVisit;
    }
    private void convertToEntity(Visit visit , VisitDTO dto){
        visit.setId(dto.getId());
        visit.setCreatedAt(dto.getCreatedAt());
        visit.setDiagnosis(dto.getDiagnosis());
        visit.setDoctor(dto.getDoctor());
        visit.setDoctorId(dto.getDoctorId());
        visit.setPatient(dto.getPatient());
        visit.setPatientId(dto.getPatientId());
    }
    public Visit delete(Integer id) {
        Visit visit = getEntity(id);
        visitRepository.save(visit);
        return visit;
    }


}
