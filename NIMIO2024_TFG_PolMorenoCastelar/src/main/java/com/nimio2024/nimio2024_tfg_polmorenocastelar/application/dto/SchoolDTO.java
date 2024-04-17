package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;

public class SchoolDTO {

    private String schoolName;
    private Float school_location_latitude;
    private Float school_location_longitude;
    private final CenterDTO center;

    // Constructor
    public SchoolDTO() {
        this.center = new CenterDTO();
    }
    public SchoolDTO(String schoolName, Float school_location_latitude, Float school_location, CenterDTO centerDTO) {
        this.schoolName = schoolName;
        this.school_location_latitude = school_location_latitude;
        this.school_location_longitude = school_location;
        this.center = centerDTO;
    }
    public SchoolDTO(School school){
        this.schoolName = school.getSchoolName();
        this.school_location_latitude = school.getSchoolLocationLatitude();
        this.school_location_longitude = school.getSchoolLocationLongitude();
        this.center = new CenterDTO(school.getCenter());
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Float getSchool_location_latitude() {
        return school_location_latitude;
    }

    public void setSchool_location_latitude(Float school_location_latitude) {
        this.school_location_latitude = school_location_latitude;
    }

    public Float getSchool_location_longitude() {
        return school_location_longitude;
    }

    public void setSchool_location_longitude(Float school_location_longitude) {
        this.school_location_longitude = school_location_longitude;
    }

    public CenterDTO getCenter() {
        return this.center;
    }
}

