package com.pankosdev.hrmanager.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "academic_institution")
@Getter
@Setter
public class AcademicInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String abbreviation;

    private String country;

    private String city;

    private String website;
}
