package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.PersonNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Collector;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.CourseRepository;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CollectorService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CourseService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.PersonService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.StudentService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    StudentService studentService;
    CourseService courseService;
    PersonService personService;

    CollectorService collectorService;

    public StudentController(StudentService studentService, CourseService courseService, PersonService personService, CollectorService collectorService){

        this.studentService = studentService;
        this.courseService = courseService;
        this.personService = personService;
        this.collectorService = collectorService;
    }

    public Student createStudent(StudentDTO studentDTO, Long courseId) throws StudentAlreadyExistsException, CourseDoNotExistException {
        if(studentService.getStudentByDNI(studentDTO.getStudentDNI()) != null){
            throw new StudentAlreadyExistsException("Student with DNI: " + studentDTO.getStudentDNI() + " already exists");
        }
        Student student = new Student(studentDTO);
        Course course = courseService.getCourseById(courseId);
        if(course == null){
            throw new CourseDoNotExistException("Course with ID: " + courseId + " does not exist");
        }
        course.addStudent(student);
        courseService.saveCourse(course);
        return studentService.saveStudent(student);
    }
    public Student createStudent(StudentDTO studentDTO) throws StudentAlreadyExistsException {
        if(studentService.getStudentByDNI(studentDTO.getStudentDNI()) != null){
            throw new StudentAlreadyExistsException("Student with DNI: " + studentDTO.getStudentDNI() + " already exists");

        }
        Student student = new Student(studentDTO);
        return studentService.saveStudent(student);
    }

    public List<Student> getStudentByCourseId(Long courseId) throws CourseDoNotExistException {
        Course course = courseService.getCourseById(courseId);
        if(course == null){
            throw new CourseDoNotExistException("Course with ID: " + courseId + " does not exist");
        }
        return course.getStudents();
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student updateStudent(Long studentId, StudentDTO studentDTO) throws StudentNotExistsException {
        Student student = studentService.getStudentById(studentId);
        if(student == null){
            throw new StudentNotExistsException("Student with ID: " + studentId + " does not exist");
        }
        student.setStudentDNI(studentDTO.getStudentDNI());
        student.setStudentName(studentDTO.getStudentName());
        student.setStudentSurname(studentDTO.getStudentSurname());
        return studentService.saveStudent(student);
    }

    public Student getStudentById(Long studentId) throws StudentNotExistsException {
        Student s = studentService.getStudentById(studentId);
        if(s == null){
            throw new StudentNotExistsException("Student with ID: " + studentId + " does not exist");
        }
        return s;
    }


    public void deleteStudent(Long studentId) {
        studentService.deleteStudent(studentId);
    }

    public void deleteAuth(Long personId, Long studentId) {
        Student student = studentService.getStudentById(studentId);
        Person person = personService.getPersonById(personId);
        collectorService.deleteCollectorByStudentAndPerson(student, person);
    }


    public boolean checkAuth(Long personId, Long studentId) throws StudentNotExistsException, PersonNotExistsException {
        Student student = studentService.getStudentById(studentId);
        if(student == null){
            throw new StudentNotExistsException("Student with ID: " + studentId + " does not exist");
        }
        Person person = personService.getPersonById(personId);
        if(person == null){
            throw new PersonNotExistsException("Person with ID: " + personId + " does not exist");
        }
        List<Collector> collectorList = student.getCollectorList();
        for(Collector c : collectorList){
            if(c.getPerson().equals(person)){
                return true;
            }
        }
        return false;
    }
}
