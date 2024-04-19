package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CourseDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.CourseController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseRestController {
    CourseController courseController;

    public CourseRestController(CourseController courseController) {
        this.courseController = courseController;
    }

    @PostMapping("/{schoolId}")
    public void createCourse(@RequestBody CourseDTO courseDTO, @PathVariable Long schoolId){
        courseController.createCourse(courseDTO, schoolId);
    }
}
