package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;

public class StudentDTO {
    private String studentName;
    private String studentSurname;
    private String studentDNI;
    private Course course;

    public StudentDTO() {
    }

    public StudentDTO(String studentName, String studentSurname, String studentDNI, Course course) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentDNI = studentDNI;
        this.course = course;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentDNI() {
        return studentDNI;
    }

    public void setStudentDNI(String studentDNI) {
        this.studentDNI = studentDNI;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
