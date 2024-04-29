package com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.ClassS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassS, Long> {

}
