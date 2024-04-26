package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.SchoolDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.SchoolAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.SchoolDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
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

    public School createSchool(SchoolDTO schoolDTO, Long centerId) throws SchoolAlreadyExistsException, CenterDoNotExistException {
        School school = new School(schoolDTO);
        if(schoolService.getSchoolByName(school.getSchoolName()).isPresent()) {
            throw new SchoolAlreadyExistsException("School with name [" + schoolDTO.getSchoolName() + "] already exists");
        }
        Center center = centerService.getCenterById(centerId);
        if(center == null){
            throw new CenterDoNotExistException("Center with id " + centerId + " not found, check the center id");
        }
        school.setCenter(center);
        centerService.addSchool(center, school);
        return schoolService.saveSchool(school);
    }

    public School getSchool(Long schoolId) throws SchoolDoNotExistException {
        School school = schoolService.getSchoolById(schoolId);
        if(school == null){
            throw new SchoolDoNotExistException("School with id " + schoolId + " not found, check the school id");
        }
        return school;
    }

    public List<Course> getSchoolCourses(Long schoolId) throws SchoolDoNotExistException {
        School school = schoolService.getSchoolById(schoolId);
        if(school == null){
            throw new SchoolDoNotExistException("School with id " + schoolId + " not found, check the school id");
        }
        return school.getCourseList();
    }

    public School updateSchool(Long schoolId, SchoolDTO schoolDTO) throws SchoolDoNotExistException {
        School school = schoolService.getSchoolById(schoolId);
        if(school == null){
            throw new SchoolDoNotExistException("School with id " + schoolId + " not found, check the school id");
        }
        school.setSchoolName(schoolDTO.getSchoolName());
        school.setSchoolLocationLatitude(schoolDTO.getSchool_location_latitude());
        school.setSchoolLocationLongitude(schoolDTO.getSchool_location_longitude());
        school.setCourseList(schoolDTO.getCourseList());
        return schoolService.saveSchool(school);
    }
    public void deleteSchool(Long schoolId) {
        schoolService.deleteSchool(schoolId);
    }

    public String getCenterNameBySchoolId(Long schoolId) throws SchoolDoNotExistException {
        School school = schoolService.getSchoolById(schoolId);
        if(school == null){
            throw new SchoolDoNotExistException("School with id " + schoolId + " not found, check the school id");
        }
        return school.getCenter().getCenterName();
    }

    public School updateSchoolName(Long schoolId, String schoolName) throws SchoolDoNotExistException {
        School school = schoolService.getSchoolById(schoolId);
        if(school == null){
            throw new SchoolDoNotExistException("School with id " + schoolId + " not found, check the school id");
        }
        school.setSchoolName(schoolName);
        return schoolService.saveSchool(school);
    }

    public List<Teacher> getTeachersFromSchool(Long schoolId) throws SchoolDoNotExistException {
        School school = schoolService.getSchoolById(schoolId);
        if(school == null){
            throw new SchoolDoNotExistException("School with id " + schoolId + " not found, check the school id");
        }
        return school.getTeachers();
    }
}
