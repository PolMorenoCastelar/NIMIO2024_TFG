package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;


import javax.persistence.*;

@Entity
@Table(name = "center")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerId;

    @Column(name = "centerName")
    private String centerName;



    public Center() {
    }
    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
}
