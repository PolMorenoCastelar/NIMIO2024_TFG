package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.CenterRepository;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolService {
    SchoolRepository schoolRepository;
    CenterRepository centerRepository;

    public SchoolService(SchoolRepository schoolRepository) {this.schoolRepository = schoolRepository;}


    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public School getSchoolById(Long schoolId) {return schoolRepository.findById(schoolId).get();}
    public void deleteSchool(Long schoolId) {schoolRepository.deleteById(schoolId);}

    public Optional<Object> getSchoolByName(String schoolName) {
        return schoolRepository.findSchoolBySchoolName(schoolName);
    }
}
