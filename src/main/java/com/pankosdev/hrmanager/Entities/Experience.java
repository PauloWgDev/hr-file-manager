package com.pankosdev.hrmanager.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Getter
@Setter
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String role;

    private LocalDate startDate;

    private LocalDate endDate;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_candidate")
    private Candidate candidate;
}
