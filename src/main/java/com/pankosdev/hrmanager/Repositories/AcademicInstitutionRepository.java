package com.pankosdev.hrmanager.Repositories;

import com.pankosdev.hrmanager.Entities.AcademicInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicInstitutionRepository extends JpaRepository<AcademicInstitution, Long> {
    boolean existsByName(String name);
}
