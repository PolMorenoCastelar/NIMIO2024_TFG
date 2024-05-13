package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "collector")
public class Collector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collector_id;

    @Column(name = "collected_date")
    private String collected_date;

    @Column(name = "collected_time")
    private String collected_time;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "person")
    private Person person;

    public Collector() {
    }

    public Collector(String collected_date, String collected_time, Student student, Person person) {
        this.collected_date = collected_date;
        this.collected_time = collected_time;
        this.student = student;
        this.person = person;
    }

    public Collector(Student student, Person person) {
        this.student = student;
        this.person = person;
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

    public void setStudent(Student student) {
        this.student = student;
    }

   public Person getPerson() {return person;}

    public void setPerson(Person person) {
        this.person = person;
    }

}
