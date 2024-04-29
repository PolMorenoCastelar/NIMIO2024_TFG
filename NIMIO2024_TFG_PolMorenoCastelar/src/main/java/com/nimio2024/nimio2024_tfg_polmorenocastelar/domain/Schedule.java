package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ScheduleDTO;
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

    @ManyToOne
    @JoinColumn(name = "classS")
    private ClassS classS;

    public Schedule() {
    }


    public Schedule(String startTimeClass, String endTimeClass, Course course, ClassS classS) {
        this.startTimeClass = startTimeClass;
        this.endTimeClass = endTimeClass;
        this.course = course;
        this.classS = classS;
    }

    public Schedule (ScheduleDTO scheduleDTO){
        this.startTimeClass = scheduleDTO.getStartTimeClass();
        this.endTimeClass = scheduleDTO.getEndTimeClass();
        this.course = scheduleDTO.getCourse();
        this.classS = scheduleDTO.getClassS();
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

    public ClassS getClassS() {
        return classS;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setClassS(ClassS classS) {
        this.classS = classS;
    }
}
