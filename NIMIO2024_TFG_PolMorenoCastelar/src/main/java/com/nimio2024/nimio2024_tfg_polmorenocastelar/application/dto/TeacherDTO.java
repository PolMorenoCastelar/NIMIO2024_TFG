package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;


import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;

import java.util.List;

public class TeacherDTO {
    private String teacherName;
    private String teacherSurname;
    private String teacherDNI;
    //private List<Course> courses;


    public TeacherDTO() {
    }

    public TeacherDTO(Teacher teacher){
        this.teacherName = teacher.getTeacherName();
        this.teacherSurname = teacher.getTeacherSurname();
        this.teacherDNI = teacher.getTeacherDNI();
       // this.courses = teacher.getTeacherCourses();
    }

    public TeacherDTO(String teacherName, String teacherSurname, String teacherDNI) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherDNI = teacherDNI;
    }

    public TeacherDTO(String teacherName, String teacherSurname, String teacherDNI,List<Course> courses) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherDNI = teacherDNI;
       // this.courses = courses;
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

    /*public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }*/

    public String getTeacherDNI() {
        return teacherDNI;
    }

    public String getTeacher_DNI() {
        return teacherDNI;
    }

    public void setTeacher_DNI(String teacher_DNI) {
        this.teacherDNI = teacher_DNI;
    }
}
