package com.pankosdev.hrmanager.Services;

import com.pankosdev.hrmanager.DOTs.CandidateLanguageDTO;
import com.pankosdev.hrmanager.DOTs.CandidateUploadDTO;
import com.pankosdev.hrmanager.DOTs.EducationDTO;
import com.pankosdev.hrmanager.Entities.Candidate;
import com.pankosdev.hrmanager.Entities.CandidateLanguage;
import com.pankosdev.hrmanager.Entities.Education;
import com.pankosdev.hrmanager.Entities.Skill;
import com.pankosdev.hrmanager.Repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    private final SkillRepository skillRepository;

    private final LanguageRepository languageRepository;

    private final LanguageProficiencyRepository languageProficiencyRepository;

    private final AcademicInstitutionRepository academicInstitutionRepository;

    public CandidateService(
            CandidateRepository candidateRepository,
            SkillRepository skillRepository,
            LanguageRepository languageRepository,
            LanguageProficiencyRepository languageProficiencyRepository,
            AcademicInstitutionRepository academicInstitutionRepository
    ) {
        this.candidateRepository = candidateRepository;
        this.skillRepository = skillRepository;
        this.languageRepository = languageRepository;
        this.languageProficiencyRepository = languageProficiencyRepository;
        this.academicInstitutionRepository = academicInstitutionRepository;
    }

    public List<Candidate> getAllCandidates()
    {
        return candidateRepository.findAll();
    }

    public Candidate uploadCandidate(
            CandidateUploadDTO dto,
            MultipartFile file
    ) throws IOException {

        String uploadDir = "uploads/";

        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename =
                UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path filePath = Paths.get(uploadDir, filename);

        Files.copy(file.getInputStream(), filePath);

        Candidate candidate = new Candidate();

        candidate.setNames(dto.getNames());
        candidate.setLastnames(dto.getLastnames());
        candidate.setProfesion(dto.getProfesion());
        candidate.setEmail(dto.getEmail());
        candidate.setPhoneNumber(dto.getPhoneNumber());
        candidate.setBirthdate(dto.getBirthdate());
        candidate.setSummaryCv(dto.getSummaryCv());

        candidate.setInsertionDate(LocalDate.now());

        candidate.setCvFileUrl(filePath.toString());

        // Skills
        Set<Skill> skills = new HashSet<>(
                skillRepository.findAllById(dto.getSkillIds())
        );

        candidate.setSkills(skills);

        // Languages
        for (CandidateLanguageDTO languageDTO : dto.getLanguages()) {

            CandidateLanguage candidateLanguage =
                    new CandidateLanguage();

            candidateLanguage.setCandidate(candidate);

            candidateLanguage.setLanguage(
                    languageRepository.findById(
                            languageDTO.getLanguageId()
                    ).orElseThrow()
            );

            candidateLanguage.setProficiency(
                    languageProficiencyRepository.findById(
                            languageDTO.getProficiencyId()
                    ).orElseThrow()
            );

            candidate.getLanguages().add(candidateLanguage);
        }

        // Education
        for (EducationDTO educationDTO : dto.getEducation()) {

            Education education = new Education();

            education.setCandidate(candidate);

            education.setDegree(educationDTO.getDegree());

            education.setStartDate(educationDTO.getStartDate());

            education.setEndDate(educationDTO.getEndDate());

            education.setDescription(
                    educationDTO.getDescription()
            );

            education.setInstitution(
                    academicInstitutionRepository.findById(
                            educationDTO.getInstitutionId()
                    ).orElseThrow()
            );

            candidate.getEducation().add(education);
        }

        return candidateRepository.save(candidate);
    }
}
