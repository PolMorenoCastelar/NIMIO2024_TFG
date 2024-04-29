package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.ClassS;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.ClassRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }


    public ClassS saveClass(ClassS classS) {
        return classRepository.save(classS);
    }
}
