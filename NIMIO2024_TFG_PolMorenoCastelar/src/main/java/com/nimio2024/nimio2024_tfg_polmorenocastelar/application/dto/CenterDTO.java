package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;

public class CenterDTO {

    private String centerName;

    public CenterDTO() {
    }

    public CenterDTO(String centerName) {
        this.centerName = centerName;
    }

    public CenterDTO(Center center){
        this.centerName = center.getCenterName();
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
}
