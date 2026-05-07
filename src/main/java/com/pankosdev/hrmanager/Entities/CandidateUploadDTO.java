package com.pankosdev.hrmanager.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CandidateUploadDTO {

    private String names;

    private String lastnames;

    private String profesion;

    private String email;

    private String phoneNumber;

    private String summaryCv;

    private List<Integer> skillIds;
}
