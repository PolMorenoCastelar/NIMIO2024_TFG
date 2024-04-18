package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;

public class SchoolDTO {

    private String schoolName;
    private Float school_location_latitude;
    private Float school_location_longitude;

    private Center center;

    public SchoolDTO(){

    }
    public SchoolDTO(String schoolName, Float school_location_latitude, Float school_location,Center center) {
        this.schoolName = schoolName;
        this.school_location_latitude = school_location_latitude;
        this.school_location_longitude = school_location;
        this.center = center;
    }
    public SchoolDTO(School school){
        this.schoolName = school.getSchoolName();
        this.school_location_latitude = school.getSchoolLocationLatitude();
        this.school_location_longitude = school.getSchoolLocationLongitude();
        this.center = school.getCenter();
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

    public Center getCenter() {
        return center;
    }
}

