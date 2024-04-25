package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CourseDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.SchoolDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CourseService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.SchoolService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.StudentService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
    CourseService courseService;

    SchoolService schoolService;

    StudentService studentService;

    public CourseController(CourseService courseService, SchoolService schoolService, StudentService studentService) {
        this.courseService = courseService;
        this.schoolService = schoolService;
        this.studentService = studentService;
    }

    public Course createCourse(CourseDTO courseDTO, Long schoolId) throws SchoolDoNotExistException {
        School school = schoolService.getSchoolById(schoolId);
        if(school==null){
            throw new SchoolDoNotExistException("School with id "+ schoolId +" does not exist");
        }
        return courseService.createCourse(courseDTO, school);

    }

    public Course updateCourseName(Long courseId, CourseDTO courseDTO) throws CourseDoNotExistException {
        Course course = courseService.getCourseById(courseId);
        if(course==null){
            throw new CourseDoNotExistException("Course with id "+ courseId +" does not exist");
        }
        course.setCourseName(courseDTO.getCourseName());
        return courseService.saveCourse(course);
    }

    public Course addStudentToCourse(Long courseId, Long studentId) throws CourseDoNotExistException, StudentNotExistsException {
        Course course = courseService.getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);
        if(student==null){
            throw new StudentNotExistsException("Student with id "+ studentId +" does not exist");
        }
        if(course==null){
            throw new CourseDoNotExistException("Course with id "+ courseId +" does not exist");
        }
        student.setCourse(course);
        course.addStudent(student);
        return courseService.saveCourse(course);

    }

    public Course getCourseById(Long courseId) throws CourseDoNotExistException {
        if(courseService.getCourseById(courseId)==null){
            throw new CourseDoNotExistException("Course with id "+ courseId +" does not exist");
        }
        return courseService.getCourseById(courseId);
    }

    public void deleteCourse(Long courseId) {
        Course course = courseService.getCourseById(courseId);
        List<Student> students = course.getStudents();
        for(Student student: students){
            student.setCourse(null);
            studentService.saveStudent(student);
        }
        courseService.deleteCourse(course);
    }

    public Course addStudentListToCourse(Long courseId, List<StudentDTO> studentListDTO) throws CourseDoNotExistException {
        Course course = courseService.getCourseById(courseId);
        if(course==null){
            throw new CourseDoNotExistException("Course with id "+ courseId +" does not exist");
        }

        for (StudentDTO studentDTO : studentListDTO) {
            if(checkStudentExists(studentDTO)){
                System.err.println("Student with DNI:"+ studentDTO.getStudentDNI() +"already exists");
                Student student = studentService.getStudentByDNI(studentDTO.getStudentDNI());
                studentService.saveStudent(student);
                if(student.getCourse()!=course){
                    System.err.println("Student with DNI:"+ studentDTO.getStudentDNI() +" now takes part of this course");
                    course.addStudent(student);
                }
            }else{
                Student student = new Student(studentDTO);
                studentService.saveStudent(student);
                course.addStudent(student);
            }
        }
        return courseService.saveCourse(course);
    }

    private boolean checkStudentExists(StudentDTO studentDTO) {
        return studentService.getStudentByDNI(studentDTO.getStudentDNI())!=null;
    }

    public Course addStudentToCourseByDNI(Long courseId, String studentDNI) throws CourseDoNotExistException, StudentNotExistsException {
        Student student = studentService.getStudentByDNI(studentDNI);
        Course course = courseService.getCourseById(courseId);
        if(student==null){
            throw new StudentNotExistsException("Student with DNI "+ studentDNI +" does not exist");
        }
        if(course==null){
            throw new CourseDoNotExistException("Course with id "+ courseId +" does not exist");
        }

            student.setCourse(course);
            course.addStudent(student);
            return courseService.saveCourse(course);
    }

    public Course migrateStudentsToCourse(Long oldCourseId, Long newCourseId) throws CourseDoNotExistException {
        Course cOld = courseService.getCourseById(oldCourseId);
        Course cNew = courseService.getCourseById(newCourseId);
        if(cOld==null || cNew==null){
            throw new CourseDoNotExistException("Course with id "+ oldCourseId +" or "+ newCourseId +" does not exist");
        }

        List<Student> students = cOld.getStudents();
        for(Student student: students){
            student.setCourse(cNew);
            cNew.addStudent(student);
        }
        cOld.cleanCourse();
        courseService.saveCourse(cNew);
        return cNew;
    }
}
