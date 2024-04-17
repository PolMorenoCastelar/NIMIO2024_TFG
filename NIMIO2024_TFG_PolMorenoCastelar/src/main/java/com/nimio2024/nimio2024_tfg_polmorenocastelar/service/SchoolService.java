package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {this.schoolRepository = schoolRepository;}


}
