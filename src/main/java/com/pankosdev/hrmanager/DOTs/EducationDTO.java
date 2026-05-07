package com.pankosdev.hrmanager.DOTs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EducationDTO {
    private Long institutionId;

    private String degree;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;
}
