package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Collector;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Person;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.CollectorRepository;
import org.springframework.stereotype.Service;

@Service
public class CollectorService {
    CollectorRepository collectorRepository;

    public CollectorService(CollectorRepository collectorRepository) {
        this.collectorRepository = collectorRepository;
    }

    public void saveCollector(Collector collector) {
        collectorRepository.save(collector);
    }

    public void deleteCollectorByStudentAndPerson(Student student, Person person) {
        collectorRepository.delete(collectorRepository.findCollectorByStudentAndPerson(student, person));
    }
}
