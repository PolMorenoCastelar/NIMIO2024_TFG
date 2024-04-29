package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ClassDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.ClassS;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.ClassService;
import org.springframework.stereotype.Controller;

@Controller
public class ClassController {

    ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    public ClassS createClass(ClassDTO classDTO) {
        ClassS classS = new ClassS(classDTO);
        return classService.saveClass(classS);
    }

    public ClassS getClassById(Long classId) {
        return classService.getClassById(classId);
    }


    public void deleteClass(Long classId) {
        classService.deleteClass(classId);
    }
}
