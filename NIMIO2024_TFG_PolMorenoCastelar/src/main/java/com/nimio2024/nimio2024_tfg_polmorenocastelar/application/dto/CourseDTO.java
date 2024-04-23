package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;

public class CourseDTO {

    private String courseName;
    private School school;

    private Teacher teacher;

    public CourseDTO() {
    }

    public CourseDTO(String courseName) {
        this.courseName = courseName;
        this.school = null;
        this.teacher = null;
    }
    public CourseDTO(String courseName, School school) {
        this.courseName = courseName;
        this.school = school;
        this.teacher = null;
    }

    public CourseDTO(Course course) {
        this.courseName = course.getCourseName();
        this.school = course.getSchool();
        this.teacher = course.getTeacher();
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
