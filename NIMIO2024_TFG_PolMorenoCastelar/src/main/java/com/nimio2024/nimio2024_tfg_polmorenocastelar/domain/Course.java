package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    @Column(name = "course_name")
    private String course_name;

    //@Column(name = "course_student_list")
    //private List<Student> studentList;
    //TODO: Add studentList
    @ManyToOne
    @JoinColumn(name = "school_id")
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

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
