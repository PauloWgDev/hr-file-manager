package com.pankosdev.hrmanager.Repositories;

import com.pankosdev.hrmanager.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByEmail(String email);

    List<Candidate> findByProfesionContainingIgnoreCase(String profesion);

    List<Candidate> findBySkills_Name(String skillName);
}
