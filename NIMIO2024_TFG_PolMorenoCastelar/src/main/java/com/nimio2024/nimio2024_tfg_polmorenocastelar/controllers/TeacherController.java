package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.TeacherService;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

}
