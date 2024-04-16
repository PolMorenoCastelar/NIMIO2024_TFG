package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;


import jakarta.persistence.*;


import org.springframework.stereotype.*;


@Entity
@Table(name = "center")
public class Center  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "centerId", nullable = false)
    private Long id;


    @Column(name = "centerName")
    private String centerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Center() {
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
}
