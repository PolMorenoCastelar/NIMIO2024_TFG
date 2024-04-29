package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.ClassS;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;

public class ScheduleDTO {

    private String startTimeClass;
    private String endTimeClass;

    private Course course;

    private ClassS classS;

    public ScheduleDTO(){

    }

    public ScheduleDTO(String startTimeClass, String endTimeClass, Course course, ClassS classS) {
        this.startTimeClass = startTimeClass;
        this.endTimeClass = endTimeClass;
        this.course = course;
        this.classS = classS;
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

    public ClassS getClassS() {
        return classS;
    }
    public void setClassS(ClassS classS) {
        this.classS = classS;
    }
}
