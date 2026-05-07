package com.pankosdev.hrmanager.DOTs.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CandidateResponseDTO {

    private Long cvId;

    private String names;

    private String lastnames;

    private String profesion;

    private String email;

    private String phoneNumber;

    private LocalDate birthdate;

    private LocalDate insertionDate;

    private String summaryCv;

    private String cvFileUrl;

    private List<String> skills;

    private List<LanguageResponseDTO> languages;

    private List<EducationResponseDTO> education;
}