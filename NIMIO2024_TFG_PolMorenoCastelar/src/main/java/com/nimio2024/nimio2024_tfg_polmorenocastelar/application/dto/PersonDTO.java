package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;

public class PersonDTO {

    private String personName;

    private String personSurname;

    private String personDNI;

    public PersonDTO() {
    }

    public PersonDTO(String personName, String personSurname, String personDNI) {
        this.personName = personName;
        this.personSurname = personSurname;
        this.personDNI = personDNI;
    }

    public PersonDTO( Person person){
        this.personName = person.getPersonName();
        this.personSurname = person.getPersonSurname();
        this.personDNI = person.getPersonDNI();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public String getPersonDNI() {
        return personDNI;
    }

    public void setPersonDNI(String personDNI) {
        this.personDNI = personDNI;
    }
}
