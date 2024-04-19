package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CourseDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CourseService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.SchoolService;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {
    CourseService courseService;

    SchoolService schoolService;

    public CourseController(CourseService courseService, SchoolService schoolService){

        this.courseService = courseService;
        this.schoolService = schoolService;
    }

    public Course createCourse(CourseDTO courseDTO, Long schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return courseService.createCourse(courseDTO, school);

    }
}
