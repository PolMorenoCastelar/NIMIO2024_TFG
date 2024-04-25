package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.SchoolDTO;
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

    @PostMapping("/{centerId}")
    public School createSchool(@RequestBody SchoolDTO schoolDTO, @PathVariable Long centerId){
       return schoolController.createSchool(schoolDTO, centerId);
    }

    @GetMapping("/{schoolId}")
    public School getSchool(@PathVariable Long schoolId){
        return schoolController.getSchool(schoolId);
    }
    @GetMapping("/{schoolId}/courses")
    public List<Course> getSchoolCourses(@PathVariable Long schoolId){
        return schoolController.getSchoolCourses(schoolId);
    }
    @PutMapping("/{schoolId}")
    public School updateSchool(@PathVariable Long schoolId, @RequestBody SchoolDTO schoolDTO){
        return schoolController.updateSchool(schoolId, schoolDTO);
    }
    @PutMapping("/{schoolId}/schoolName")
    public School updateSchoolName(@PathVariable Long schoolId, @RequestBody String schoolName){
        return schoolController.updateSchoolName(schoolId, schoolName);
    }
    @DeleteMapping("/{schoolId}")
    public void deleteSchool(@PathVariable Long schoolId){
        schoolController.deleteSchool(schoolId);
    }
    @GetMapping("/centerName/{schoolId}")
    public String getCenterNameBySchoolId(@PathVariable Long schoolId){
        return schoolController.getCenterNameBySchoolId(schoolId);
    }
    @GetMapping("/teachersFromSchool/{schoolId}")
    public List<Teacher> getTeachersFromSchool(@PathVariable Long schoolId){
        return schoolController.getTeachersFromSchool(schoolId);
    }
}
