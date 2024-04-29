package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ClassDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classS")
public class ClassS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long class_id;

    @Column (name = "class_name")
    private String class_name;

    @Column (name = "class_number")
    private String class_number;

    @Column (name = "class_location")
    private String class_location;

    @OneToMany(mappedBy = "classS")
    private List<Schedule> schedule = new ArrayList<>();

    public ClassS() {
    }

    public ClassS(String class_name, String class_number, String class_location, List<Schedule> schedule) {
        this.class_name = class_name;
        this.class_number = class_number;
        this.class_location = class_location;
        this.schedule = schedule;
    }

    public ClassS(String class_name, String class_number, String class_location) {
        this.class_name = class_name;
        this.class_number = class_number;
        this.class_location = class_location;
    }

    public ClassS(ClassDTO classDTO){
        this.class_name = classDTO.getClassName();
        this.class_number = classDTO.getClassNumber();
        this.class_location = classDTO.getClassLocation();
        this.schedule = classDTO.getClassSchedule();
    }

    public String getClassName() {
        return class_name;
    }

    public void setClassName(String class_name) {
        this.class_name = class_name;
    }

    public String getClassNumber() {
        return class_number;
    }

    public void setClassNumber(String class_number) {
        this.class_number = class_number;
    }

    public String getClassLocation() {
        return class_location;
    }

    public void setClassLocation(String class_location) {
        this.class_location = class_location;
    }

    public List<Schedule> getClassSchedule() {
        return schedule;
    }

}
