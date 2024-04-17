package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.SchoolDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_location_latitude")
    private Float schoolLocationLatitude;

    @Column(name = "school_location_longitude")
    private Float schoolLocationLongitude;

    //TODO : courses list to add here

    @ManyToOne
    @JoinColumn(name = "center_uuid")
    private Center center;

    public School() {
    }

    public School(String schoolName, Float schoolLocationLatitude, Float schoolLocationLongitude, Center center) {
        this.schoolName = schoolName;
        this.schoolLocationLatitude = schoolLocationLatitude;
        this.schoolLocationLongitude = schoolLocationLongitude;
        this.center = center;
    }

    public School(SchoolDTO schoolDTO){
        this.schoolName = schoolDTO.getSchoolName();
        this.schoolLocationLatitude = schoolDTO.getSchool_location_latitude();
        this.schoolLocationLongitude = schoolDTO.getSchool_location_longitude();
        this.center = new Center(schoolDTO.getCenter());
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

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}
