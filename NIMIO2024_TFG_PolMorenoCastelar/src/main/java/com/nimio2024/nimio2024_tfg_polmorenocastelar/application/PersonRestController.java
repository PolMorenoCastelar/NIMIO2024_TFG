package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.PersonDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.PersonAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.PersonNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.PersonController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonRestController {

    PersonController  personController;

    public PersonRestController(PersonController personController) {
        this.personController = personController;
    }

    @PostMapping("")
    public Person createPerson(@RequestBody PersonDTO personDTO) throws PersonAlreadyExistsException {
        return personController.createPerson(personDTO);
    }

    @PutMapping("/{personId}")
    public Person updatePerson(@PathVariable Long personId, @RequestBody PersonDTO personDTO) throws PersonNotExistsException {
        return personController.updatePerson(personId, personDTO);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personController.deletePerson(personId);
    }

}
