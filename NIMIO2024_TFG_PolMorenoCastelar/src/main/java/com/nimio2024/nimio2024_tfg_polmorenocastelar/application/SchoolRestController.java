package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.SchoolDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.SchoolAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.SchoolDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.SchoolController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolRestController {

    SchoolController schoolController;

    public SchoolRestController(SchoolController schoolController) {this.schoolController = schoolController;}

    @PostMapping("/{centerId}") // SC6F
    public School createSchool(@RequestBody SchoolDTO schoolDTO, @PathVariable Long centerId) throws CenterDoNotExistException, SchoolAlreadyExistsException {
       return schoolController.createSchool(schoolDTO, centerId);
    }
    @PutMapping("/{schoolId}") // SC9F
    public School updateSchool(@PathVariable Long schoolId, @RequestBody SchoolDTO schoolDTO) throws SchoolDoNotExistException {
        return schoolController.updateSchool(schoolId, schoolDTO);
    }
    @PutMapping("/{schoolId}/schoolName") // EX48F
    public School updateSchoolName(@PathVariable Long schoolId, @RequestBody String schoolName) throws SchoolDoNotExistException {
        return schoolController.updateSchoolName(schoolId, schoolName);
    }
    @GetMapping("/{schoolId}") // SC7F
    public School getSchool(@PathVariable Long schoolId) throws SchoolDoNotExistException {
        return schoolController.getSchool(schoolId);
    }
    @GetMapping("/{schoolId}/courses") // SC8F
    public List<Course> getSchoolCourses(@PathVariable Long schoolId) throws SchoolDoNotExistException {
        return schoolController.getSchoolCourses(schoolId);
    }
    @GetMapping("/centerName/{schoolId}") // EX47F
    public String getCenterNameBySchoolId(@PathVariable Long schoolId) throws SchoolDoNotExistException {
        return schoolController.getCenterNameBySchoolId(schoolId);
    }
    @GetMapping("/teachersFromSchool/{schoolId}") // EX51F
    public List<Teacher> getTeachersFromSchool(@PathVariable Long schoolId) throws SchoolDoNotExistException {
        return schoolController.getTeachersFromSchool(schoolId);
    }
    @DeleteMapping("/{schoolId}") // SC10F
    public void deleteSchool(@PathVariable Long schoolId){
        schoolController.deleteSchool(schoolId);
    }

}
