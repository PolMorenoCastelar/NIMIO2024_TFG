package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;

import java.util.List;

public class TeacherDTO {
    private String teacherName;
    private String teacherSurname;
    private List<Course> courses;

    public TeacherDTO() {
    }

    public TeacherDTO(Teacher teacher){
        this.teacherName = teacher.getTeacherName();
        this.teacherSurname = teacher.getTeacherSurname();
        this.courses = teacher.getTeacherCourses();
    }

    public TeacherDTO(String teacherName, String teacherSurname) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
    }

    public TeacherDTO(String teacherName, String teacherSurname, List<Course> courses) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.courses = courses;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
