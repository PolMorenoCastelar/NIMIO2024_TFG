package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.SchoolDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CenterService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.SchoolService;
import org.springframework.stereotype.Controller;

@Controller
public class SchoolController {

    SchoolService schoolService;
    CenterService centerService;

    public SchoolController(SchoolService schoolService, CenterService centerService) {
        this.schoolService = schoolService;
        this.centerService = centerService;
    }

    public School createSchool(SchoolDTO schoolDTO, Long centerId) {
        School school = new School(schoolDTO);
        Center center = centerService.getCenterById(centerId);
        school.setCenter(center);
        centerService.addSchool(center, school);
        return schoolService.saveSchool(school);
    }

    public School getSchool(Long schoolId) {
        return schoolService.getSchoolById(schoolId);
    }
}
