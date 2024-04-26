package com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT * FROM Teacher t WHERE t.teacher_dni = :teacherDni LIMIT 1", nativeQuery = true)
    Teacher findTeacherByDNI(String teacherDni);
}
