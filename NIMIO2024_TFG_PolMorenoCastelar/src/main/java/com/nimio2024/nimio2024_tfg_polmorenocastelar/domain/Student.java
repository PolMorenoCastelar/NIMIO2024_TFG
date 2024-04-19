package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

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

    //TODO : Falta lista de Courses

    //TODO : Falta lista de Parents y Auth



    public Student() {

    }
    public Student(String student_name, String student_surname, String student_DNI) {
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_DNI = student_DNI;
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
}
