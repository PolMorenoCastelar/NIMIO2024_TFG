package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CenterDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "center")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long center_id;

    @Column(name = "center_name")
    private String center_name;

    @OneToMany(mappedBy = "center")
    @JsonManagedReference
    private List<School> schoolList = new ArrayList<>();

    public Center() {

    }
    public Center (String centerName, List<School> schoolList){
        this.center_name = centerName;
        this.schoolList = schoolList;
    }
    public Center (CenterDTO centerDTO){
        this.center_name = centerDTO.getCenterName();
        this.schoolList = centerDTO.getSchoolList();
    }
    public Center(String centerName) {
        this.center_name = centerName;
    }
    public List<School> getSchoolList() {
        return schoolList;
    }
    public String getCenterName() {
        return center_name;
    }
    public void setCenterName(String centerName) {
        this.center_name = centerName;
    }
    public void addSchool(School school) {
        this.schoolList.add(school);
    }


}
