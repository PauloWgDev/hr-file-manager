package com.pankosdev.hrmanager.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "candidate")
@Data
@Getter
@Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cvId;

    private String names;
    private String lastnames;
    private String profesion;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    private LocalDate birthdate;
    private LocalDate insertionDate;

    private String cvFileUrl;

    @Lob
    private String summaryCv;
}