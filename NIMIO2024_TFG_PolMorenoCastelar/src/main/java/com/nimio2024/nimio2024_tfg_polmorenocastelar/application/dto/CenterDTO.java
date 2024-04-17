package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;

import java.util.List;

public class CenterDTO {

    private String centerName;

    private List<School> schoolList;

    public CenterDTO() {
    }

    public CenterDTO(String centerName) {
        this.centerName = centerName;
    }

    public CenterDTO(Center center){
        this.centerName = center.getCenterName();
    }

    public CenterDTO(String centerName, List<School> schoolList){
        this.centerName = centerName;
        this.schoolList = schoolList;
    }
    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public List<School> getSchoolList() {return schoolList;}
}
