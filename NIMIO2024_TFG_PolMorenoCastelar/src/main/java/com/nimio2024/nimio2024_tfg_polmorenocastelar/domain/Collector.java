package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "collector")
public class Collector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collector_id;

    //StudentID y PersonID se sustituyen por student y person
    @Column(name = "student_id")
    private Long student_id;

    @Column(name = "person_id")
    private Long person_id;

    @Column(name = "collected_date")
    private String collected_date;

    @Column(name = "collected_time")
    private String collected_time;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    public Collector() {
    }

    public Collector(Long student_id, Long person_id, String collected_date, String collected_time, Student student) {
        this.student_id = student_id;
        this.person_id = person_id;
        this.collected_date = collected_date;
        this.collected_time = collected_time;
        this.student = student;
    }


    public Long getStudentId() {
        return student_id;
    }

    public void setStudentId(Long student_id) {
        this.student_id = student_id;
    }

    public Long getPersonId() {
        return person_id;
    }

    public void setPersonId(Long person_id) {
        this.person_id = person_id;
    }

    public String getCollectedDate() {
        return collected_date;
    }

    public void setCollectedDate(String collected_date) {
        this.collected_date = collected_date;
    }

    public String getCollectedTime() {
        return collected_time;
    }

    public void setCollectedTime(String collected_time) {
        this.collected_time = collected_time;
    }

    public Student getStudent() {
        return student;
    }


}
