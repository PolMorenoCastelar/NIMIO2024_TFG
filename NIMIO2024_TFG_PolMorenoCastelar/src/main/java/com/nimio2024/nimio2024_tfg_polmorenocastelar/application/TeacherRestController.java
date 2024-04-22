package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.TeacherDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.TeacherController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherRestController {

    TeacherController teacherController;

    public TeacherRestController(TeacherController teacherController) {
        this.teacherController = teacherController;
    }

    @PostMapping("")
    public Teacher createTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherController.createTeacher(teacherDTO);
    }
}
