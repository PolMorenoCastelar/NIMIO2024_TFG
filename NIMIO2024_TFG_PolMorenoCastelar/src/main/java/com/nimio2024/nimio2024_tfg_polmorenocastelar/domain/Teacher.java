package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.TeacherDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;

    @Column(name = "teacher_name")
    private String teacher_name;

    @Column(name = "teacher_surname")
    private String teacher_surname;

    @OneToMany(mappedBy = "teacher")
    private List<Course> teacher_courses;

    public Teacher() {

    }
    public Teacher(String teacher_name, String teacher_surname) {
        this.teacher_name = teacher_name;
        this.teacher_surname = teacher_surname;
    }

    public Teacher(String teacher_name, String teacher_surname, List<Course> courses) {
        this.teacher_name = teacher_name;
        this.teacher_surname = teacher_surname;
        this.teacher_courses = courses;
    }

    public Teacher(TeacherDTO teacherDTO) {
        this.teacher_name = teacherDTO.getTeacherName();
        this.teacher_surname = teacherDTO.getTeacherSurname();
        this.teacher_courses = teacherDTO.getCourses();
    }

    public String getTeacherName() {
        return teacher_name;
    }

    public void setTeacherName(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacherSurname(){
        return teacher_surname;
    }

    public void setTeacherSurname(String teacher_surname){
        this.teacher_surname = teacher_surname;
    }

    public List<Course> getTeacherCourses() {
        return teacher_courses;
    }

    public void setTeacherCourses(List<Course> coursesList) {
        this.teacher_courses = coursesList;
    }

    public void addCourse(Course course) {
        teacher_courses.add(course);
    }
}
