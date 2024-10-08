package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ClassDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.ClassController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.ClassS;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassRestController {

    ClassController classController;

    public ClassRestController(ClassController classController) {
        this.classController = classController;
    }

    @PostMapping("/") // CL24F
    public ClassS createClass(@RequestBody ClassDTO classDTO){
            return classController.createClass(classDTO);
    }

    @GetMapping("/{classId}") // CL25F
    public ClassS getClass(@PathVariable Long classId){
        return classController.getClassById(classId);
    }

    @DeleteMapping("/{classId}") // CL26F
    public void deleteClass(@PathVariable Long classId){
        classController.deleteClass(classId);
    }

}



