package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;

public class SchoolDTO {

    private String schoolName;
    private Float schoolLocationLatitude;
    private Float schoolLocationLongitude;
    private final CenterDTO center;

    // Constructor
    public SchoolDTO() {
        this.center = new CenterDTO();
    }
    public SchoolDTO(String schoolName, Float schoolLocationLatitude, Float schoolLocationLongitude, CenterDTO centerDTO) {
        this.schoolName = schoolName;
        this.schoolLocationLatitude = schoolLocationLatitude;
        this.schoolLocationLongitude = schoolLocationLongitude;
        this.center = centerDTO;
    }
    public SchoolDTO(School school){
        this.schoolName = school.getSchoolName();
        this.schoolLocationLatitude = school.getSchoolLocationLatitude();
        this.schoolLocationLongitude = school.getSchoolLocationLongitude();
        this.center = new CenterDTO(school.getCenter());
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Float getSchoolLocationLatitude() {
        return schoolLocationLatitude;
    }

    public void setSchoolLocationLatitude(Float schoolLocationLatitude) {
        this.schoolLocationLatitude = schoolLocationLatitude;
    }

    public Float getSchoolLocationLongitude() {
        return schoolLocationLongitude;
    }

    public void setSchoolLocationLongitude(Float schoolLocationLongitude) {
        this.schoolLocationLongitude = schoolLocationLongitude;
    }

    public CenterDTO getCenter() {
        return this.center;
    }
}

