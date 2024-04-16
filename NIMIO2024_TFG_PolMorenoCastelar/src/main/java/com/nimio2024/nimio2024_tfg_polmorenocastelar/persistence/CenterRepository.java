package com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {

}
