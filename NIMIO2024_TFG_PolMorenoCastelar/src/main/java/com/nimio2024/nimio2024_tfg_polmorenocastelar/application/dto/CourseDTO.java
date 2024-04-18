package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

public class CourseDTO {

    private String courseName;
    private Long schoolId;

    public CourseDTO() {
    }

    public CourseDTO(String courseName, Long schoolId) {
        this.courseName = courseName;
        this.schoolId = schoolId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
