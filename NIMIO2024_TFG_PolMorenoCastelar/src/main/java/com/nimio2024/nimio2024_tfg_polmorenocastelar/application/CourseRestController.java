package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CourseDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.SchoolDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentNotExistsException;
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

    @PostMapping("/{schoolId}") // CO11F
    public Course createCourse(@RequestBody CourseDTO courseDTO, @PathVariable Long schoolId) throws SchoolDoNotExistException {
        return courseController.createCourse(courseDTO, schoolId);
    }

    @PutMapping("/{courseId}") // CO12F
    public Course updateCourseName(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) throws CourseDoNotExistException {
        return courseController.updateCourseName(courseId, courseDTO);
    }

    @PutMapping("/{courseId}/addStudent/{studentId}") // CO13F
    public Course addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) throws CourseDoNotExistException, StudentNotExistsException {
        return courseController.addStudentToCourse(courseId, studentId);
    }

    @PutMapping ("/{courseId}/addStudentByDNI/{studentDNI}") // EX49F
    public Course addStudentToCourseByDNI(@PathVariable Long courseId, @PathVariable String studentDNI) throws CourseDoNotExistException, StudentNotExistsException {
        return courseController.addStudentToCourseByDNI(courseId, studentDNI);
    }

    @PutMapping("/{courseId}/addStudentList") // CO14F
    public Course addStudentListToCourse(@PathVariable Long courseId, @RequestBody List<StudentDTO> studentListDTO) throws CourseDoNotExistException {
        return courseController.addStudentListToCourse(courseId, studentListDTO);
    }

    @PutMapping("/{oldCourseId}/migrateToCourse/{newCourseId}") // EX50F
    public Course migrateStudentsToCourse(@PathVariable Long oldCourseId, @PathVariable Long newCourseId) throws CourseDoNotExistException {
        return courseController.migrateStudentsToCourse(oldCourseId, newCourseId);
    }

    @GetMapping("/{courseId}") // CO15F
    public Course getCourseById(@PathVariable Long courseId) throws CourseDoNotExistException {
        return courseController.getCourseById(courseId);
    }
    @DeleteMapping("/{courseId}") // CO17F
    public void deleteCourse(@PathVariable Long courseId){
        courseController.deleteCourse(courseId);
    }

}
