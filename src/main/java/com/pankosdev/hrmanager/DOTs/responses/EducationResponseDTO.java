package com.pankosdev.hrmanager.DOTs.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EducationResponseDTO {

    private String institution;

    private String degree;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;
}
