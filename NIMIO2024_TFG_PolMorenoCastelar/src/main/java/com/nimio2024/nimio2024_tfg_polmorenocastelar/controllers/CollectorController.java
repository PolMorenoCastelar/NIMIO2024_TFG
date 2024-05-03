package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Collector;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CollectorService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.PersonService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.StudentService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CollectorController {

    CollectorService collectorService;

    PersonService personService;

    StudentService studentService;

    public CollectorController(CollectorService collectorService, PersonService personService, StudentService studentService) {
        this.collectorService = collectorService;
        this.personService = personService;
        this.studentService = studentService;
    }

    public Student addPersonToStudent(Long studentId, Long personId) throws StudentNotExistsException {
        Student student = studentService.getStudentById(studentId);
        if(student == null){
            throw new StudentNotExistsException("Student with ID: " + studentId + " does not exist");
        }

        Person person = personService.getPersonById(personId);
       //TODO Exception if person do not exist

        Collector collector = new Collector(student , person);
        collectorService.saveCollector(collector);

        student.addCollector(collector);

        return studentService.saveStudent(student);
    }

    public List<Collector> getCollectorsPersonsByStudentId(Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return student.getCollectorList();
    }
}
