package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "course")
    @JsonBackReference
    private Course course;

    @OneToMany(mappedBy = "student")
    private List<Collector> collectorList;


    public Student() {

    }
    public Student(String student_name, String student_surname, String student_DNI,Course course, List<Collector> collectorList) {
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_DNI = student_DNI;
        this.course = course;
        this.collectorList = collectorList;
    }
    public Student (StudentDTO studentDTO){
        this.student_name = studentDTO.getStudentName();
        this.student_surname = studentDTO.getStudentSurname();
        this.student_DNI = studentDTO.getStudentDNI();
        this.course = studentDTO.getCourse();
        this.collectorList = studentDTO.getCollectorList();
    }


    public String getStudentName() {
        return student_name;
    }

    public void setStudentName(String student_name) {
        this.student_name = student_name;
    }

    public String getStudentSurname() {
        return student_surname;
    }

    public void setStudentSurname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getStudentDNI() {
        return student_DNI;
    }

    public void setStudentDNI(String student_DNI) {
        this.student_DNI = student_DNI;
    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Collector> getCollectorList() {
        return collectorList;
    }

    public void addCollector(Collector collector) {
        if(this.collectorList == null)
            this.collectorList = new ArrayList<>();

        this.collectorList.add(collector);
    }

    public void deleteAuth(Person person) {
        for (Collector collector : collectorList) {
            if (collector.getPerson().equals(person)) {
                collectorList.remove(collector);
                break;
            }
        }
    }
}
