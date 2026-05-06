package com.pankosdev.hrmanager.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(columnDefinition = "TEXT")
    private String summaryCv;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @ManyToMany
    @JoinTable(
            name = "candidate_skills",
            joinColumns = @JoinColumn(name = "id_candidate"),
            inverseJoinColumns = @JoinColumn(name = "id_skill")
    )
    @JsonManagedReference
    private Set<Skill> skills = new HashSet<>();
}