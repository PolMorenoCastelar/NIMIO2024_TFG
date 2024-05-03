package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.PersonDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_id;

    @Column(name = "person_name")
    private String person_name;

    @Column(name = "person_surname")
    private String person_surname;

    @Column(name = "person_DNI")
    private String person_DNI;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    private List<Collector> collectorList;


    public Person() {

    }

    public Person(String person_name, String person_surname, String person_DNI, List<Collector> collectorList) {
        this.person_name = person_name;
        this.person_surname = person_surname;
        this.person_DNI = person_DNI;
        this.collectorList = collectorList;
    }

    public Person(PersonDTO personDTO) {
        this.person_name = personDTO.getPersonName();
        this.person_surname = personDTO.getPersonSurname();
        this.person_DNI = personDTO.getPersonDNI();
    }

    public String getPersonName() {
        return person_name;
    }
    public void setPersonName(String person_name) {
        this.person_name = person_name;
    }

    public String getPersonSurname() {
        return person_surname;
    }

    public void setPersonSurname(String person_surname) {
        this.person_surname = person_surname;
    }

    public String getPersonDNI() {
        return person_DNI;
    }

    public void setPersonDNI(String person_DNI) {
        this.person_DNI = person_DNI;
    }

    public List<Collector> getCollectorList() {
        return collectorList;
    }

    public void setCollectorList(List<Collector> collectorList) {
        this.collectorList = collectorList;
    }



}
