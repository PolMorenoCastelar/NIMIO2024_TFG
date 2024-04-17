package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CenterDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "center")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerId;

    @Column(name = "center_name")
    private String center_name;

    @Column(name="school_list")
    @OneToMany(mappedBy = "schoolId")
    private List<School> schoolList;

    public Center() {
    }
    public Center (String centerName) {
        this.center_name = centerName;
    }
    public Center (CenterDTO centerDTO){
        this.center_name = centerDTO.getCenterName();
    }


    public String getCenterName() {
        return center_name;
    }

    public void setCenterName(String centerName) {
        this.center_name = centerName;
    }
}
