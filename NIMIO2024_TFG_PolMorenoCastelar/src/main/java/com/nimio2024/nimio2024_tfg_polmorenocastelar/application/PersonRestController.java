package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.PersonDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.PersonController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonRestController {

    PersonController    personController;

    public PersonRestController(PersonController personController) {
        this.personController = personController;
    }

    @PostMapping("")
    public Person createPerson(@RequestBody PersonDTO personDTO) {
        return personController.createPerson(personDTO);
    }

}
