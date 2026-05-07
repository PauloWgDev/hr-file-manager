package com.pankosdev.hrmanager.DOTs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CandidateUploadDTO {

    private String names;

    private String lastnames;

    private LocalDate birthdate;

    private String profesion;

    private String email;

    private String phoneNumber;

    private String summaryCv;

    private List<Integer> skillIds;

    private List<CandidateLanguageDTO> languages;

    private List<EducationDTO> education;
}
