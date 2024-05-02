package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

}
