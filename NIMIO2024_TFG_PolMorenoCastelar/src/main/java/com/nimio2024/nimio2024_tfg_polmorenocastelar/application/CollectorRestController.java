package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.PersonNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.CollectorController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Collector;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collectors")
public class CollectorRestController {

    CollectorController collectorController;

    public CollectorRestController(CollectorController collectorController) {
        this.collectorController = collectorController;
    }

    @PutMapping("/{studentId}/auth/{personId}")
    public Student addPersonToStudent(@PathVariable Long studentId, @PathVariable Long personId) throws StudentNotExistsException, PersonNotExistsException {
        return collectorController.addPersonToStudent(studentId, personId);
    }

    @GetMapping("/auth/{studentId}") // CO27F
    public List<Collector> getCollectorsPersons(@PathVariable Long studentId) {
        return collectorController.getCollectorsPersonsByStudentId(studentId);
    }



}
