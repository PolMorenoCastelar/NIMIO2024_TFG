package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.PersonDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.PersonService;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    public Person createPerson(PersonDTO personDTO) {
        Person person = new Person(personDTO);
        return personService.savePerson(person);
    }

    public void deletePerson(Long personId) {
        personService.deletePerson(personId);
    }
}
