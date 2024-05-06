package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.PersonDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.PersonAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.PersonNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.PersonService;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    public Person createPerson(PersonDTO personDTO) throws PersonAlreadyExistsException {
        if(personService.getPersonByDni(personDTO.getPersonDNI()) != null) {
            throw new PersonAlreadyExistsException("Person with DNI " + personDTO.getPersonDNI() + " already exists");
        }

        Person person = new Person(personDTO);
        return personService.savePerson(person);
    }

    public void deletePerson(Long personId) {
        personService.deletePerson(personId);
    }

    public Person updatePerson(Long personId, PersonDTO personDTO) throws PersonNotExistsException {
        Person person = personService.getPersonById(personId);
        if(person == null) {
            throw new PersonNotExistsException("Person with ID " + personId + " does not exist");
        }
        person.setPersonDNI(personDTO.getPersonDNI());
        person.setPersonName(personDTO.getPersonName());
        person.setPersonSurname(personDTO.getPersonSurname());
        person.setParent(personDTO.isParent());
        person.setCollectorList(person.getCollectorList());
        return personService.savePerson(person);
    }
}
