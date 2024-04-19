package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CourseDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    @Column(name = "course_name")
    private String course_name;

    @ManyToOne
    @JoinColumn(name = "school")
    @JsonBackReference
    private School school;


    public Course() {
    }
    public Course(String course_name, School school) {
        this.course_name = course_name;
        this.school = school;
    }
    public Course(String course_name) {
        this.course_name = course_name;
        this.school = null;
    }
    public Course(CourseDTO courseDTO){
        this.course_name = courseDTO.getCourseName();
        this.school = courseDTO.getSchool();
    }

    public String getCourseName() {
        return course_name;
    }
    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }
    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }
}
