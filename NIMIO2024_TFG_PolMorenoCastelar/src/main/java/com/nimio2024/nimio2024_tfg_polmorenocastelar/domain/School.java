package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    @ManyToOne
    @JoinColumn(name = "fk_center_id")
    private Center center;
}
