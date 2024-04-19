package com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM Student s WHERE s.student_DNI = :dni LIMIT 1", nativeQuery = true)
    Student findStudentByDNI(String dni);

}
