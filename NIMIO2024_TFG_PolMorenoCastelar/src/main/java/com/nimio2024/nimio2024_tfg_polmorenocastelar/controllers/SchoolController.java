package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.SchoolDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CenterService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.SchoolService;
import org.springframework.stereotype.Controller;

import java.util.List;

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
        if(schoolService.getSchoolByName(school.getSchoolName()).isPresent()) {
            //throw new IllegalArgumentException("School already exists"); //TODO: THROW O SYSERR?
            System.err.println("School already exists, check the name");
            return null;
        }
        Center center = centerService.getCenterById(centerId);
        if(center == null){
            //TODO: THROW O SYSERR?
            System.err.println("Center not found, check the center id");
            return null;
        }
        school.setCenter(center);
        centerService.addSchool(center, school);
        return schoolService.saveSchool(school);
    }

    public School getSchool(Long schoolId){
        return schoolService.getSchoolById(schoolId);
    }

    public List<Course> getSchoolCourses(Long schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school.getCourseList();
    }

    public School updateSchool(Long schoolId, SchoolDTO schoolDTO) {
        School school = schoolService.getSchoolById(schoolId);
        school.setSchoolName(schoolDTO.getSchoolName());
        school.setSchoolLocationLatitude(schoolDTO.getSchool_location_latitude());
        school.setSchoolLocationLongitude(schoolDTO.getSchool_location_longitude());
        school.setCourseList(schoolDTO.getCourseList());
        return schoolService.saveSchool(school);
    }
    public void deleteSchool(Long schoolId) {
        schoolService.deleteSchool(schoolId);
    }

    public String getCenterNameBySchoolId(Long schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school.getCenter().getCenterName();
    }
}
