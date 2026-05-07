package com.pankosdev.hrmanager.Specifications;

import com.pankosdev.hrmanager.Entities.Candidate;
import com.pankosdev.hrmanager.Entities.Skill;

import jakarta.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

public class CandidateSpecification {

    public static Specification<Candidate> hasName(
            String name
    ) {
        return (root, query, criteriaBuilder) ->

                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("names")),
                        "%" + name.toLowerCase() + "%"
                );
    }

    public static Specification<Candidate> hasProfession(
            String profession
    ) {
        return (root, query, criteriaBuilder) ->

                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("profesion")),
                        "%" + profession.toLowerCase() + "%"
                );
    }

    public static Specification<Candidate> hasSkill(
            String skill
    ) {
        return (root, query, criteriaBuilder) -> {

            Join<Object, Object> skills =
                    root.join("skills");

            return criteriaBuilder.equal(
                    criteriaBuilder.lower(
                            skills.get("name")
                    ),
                    skill.toLowerCase()
            );
        };
    }

    public static Specification<Candidate> hasLanguage(
            String language
    ) {
        return (root, query, criteriaBuilder) -> {

            Join<Object, Object> languages =
                    root.join("languages")
                            .join("language");

            return criteriaBuilder.equal(
                    criteriaBuilder.lower(
                            languages.get("name")
                    ),
                    language.toLowerCase()
            );
        };
    }

}
