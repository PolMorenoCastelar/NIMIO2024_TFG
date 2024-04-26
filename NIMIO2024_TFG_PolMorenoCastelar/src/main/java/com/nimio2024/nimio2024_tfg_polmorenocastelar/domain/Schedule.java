package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(name = "startTime_class")
    private String startTimeClass;

    @Column(name = "endTime_class")
    private String endTimeClass;

    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    public Schedule() {
    }

    public Schedule(String startTimeClass, String endTimeClass, Course course) {
        this.startTimeClass = startTimeClass;
        this.endTimeClass = endTimeClass;
        this.course = course;
    }

    public String getStartTimeClass() {
        return startTimeClass;
    }

    public void setStartTimeClass(String startTimeClass) {
        this.startTimeClass = startTimeClass;
    }

    public String getEndTimeClass() {
        return endTimeClass;
    }

    public void setEndTimeClass(String endTimeClass) {
        this.endTimeClass = endTimeClass;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
