package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "student_surname")
    private String student_surname;

    @Column(name = "student_DNI")
    private String student_DNI;


    //TODO: Falta la parents list y la autorizedList
    @ManyToOne
    @JoinColumn(name = "fk_course_id")
    private Course course;

    public Student() {
    }
    public Student(String student_name, String student_surname, String student_DNI, Course course) {
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_DNI = student_DNI;
        this.course = course;
    }
    public Student(StudentDTO studentDTO) {
        this.student_name = studentDTO.getStudentName();
        this.student_surname = studentDTO.getStudentSurname();
        this.student_DNI = studentDTO.getStudentDNI();
        this.course = studentDTO.getCourse();
    }

    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public String getStudent_surname() {
        return student_surname;
    }
    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }
    public String getStudent_DNI() {
        return student_DNI;
    }
    public void setStudent_DNI(String student_DNI) {
        this.student_DNI = student_DNI;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }



}
