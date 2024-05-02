package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.CollectorController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collectors")
public class CollectorRestController {

    CollectorController collectorController;

    public CollectorRestController(CollectorController collectorController) {
        this.collectorController = collectorController;
    }

    @PutMapping("/{studentId}/auth/{personId}")
    public Student addPersonToStudent(@PathVariable Long studentId, @PathVariable Long personId) throws StudentNotExistsException {
        return collectorController.addPersonToStudent(studentId, personId);
    }


}
