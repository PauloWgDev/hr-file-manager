package com.pankosdev.hrmanager.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "candidate_language")
@Getter
@Setter
public class CandidateLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_candidate")
    @JsonBackReference
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "id_language")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "id_proficiency")
    private LanguageProficiency proficiency;
}
