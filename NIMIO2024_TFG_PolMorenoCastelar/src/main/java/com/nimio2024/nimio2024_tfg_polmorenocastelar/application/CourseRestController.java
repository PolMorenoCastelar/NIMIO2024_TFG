package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CourseDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.CourseController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseRestController {
    CourseController courseController;

    public CourseRestController(CourseController courseController) {
        this.courseController = courseController;
    }

    @PostMapping("/{schoolId}")
    public Course createCourse(@RequestBody CourseDTO courseDTO, @PathVariable Long schoolId){
        return courseController.createCourse(courseDTO, schoolId);
    }

    @PutMapping("/{courseId}")
    public Course updateCourseName(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO){
        return courseController.updateCourseName(courseId, courseDTO);
    }

    @PutMapping("/{courseId}/addStudent/{studentId}")
    public Course addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId){
        return courseController.addStudentToCourse(courseId, studentId);
    }

    @PutMapping("/{courseId}/addStudentList")
    public Course addStudentListToCourse(@PathVariable Long courseId, @RequestBody List<StudentDTO> studentListDTO){
        return courseController.addStudentListToCourse(courseId, studentListDTO);
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Long courseId){
        return courseController.getCourseById(courseId);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId){
        courseController.deleteCourse(courseId);
    }

}
