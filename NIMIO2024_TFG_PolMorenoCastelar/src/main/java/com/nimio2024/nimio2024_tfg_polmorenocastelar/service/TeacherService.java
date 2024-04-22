package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
