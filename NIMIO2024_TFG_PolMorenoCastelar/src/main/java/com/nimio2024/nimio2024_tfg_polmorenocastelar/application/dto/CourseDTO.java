package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;

public class CourseDTO {

    private String courseName;
    private School school;

    public CourseDTO() {
    }

    public CourseDTO(String courseName) {
        this.courseName = courseName;
        this.school = null;
    }
    public CourseDTO(String courseName, School school) {
        this.courseName = courseName;
        this.school = school;
    }
    public CourseDTO(Course course) {
        this.courseName = course.getCourseName();
        this.school = course.getSchool();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
