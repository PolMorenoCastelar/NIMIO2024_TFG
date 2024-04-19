package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.StudentController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    StudentController studentController;

    public StudentRestController(StudentController studentController) {
        this.studentController = studentController;
    }

    @PostMapping("{courseId}")
    public Student createStudent(@RequestBody StudentDTO studentDTO, @PathVariable Long courseId) {
        return studentController.createStudent(studentDTO, courseId);
    }
}
