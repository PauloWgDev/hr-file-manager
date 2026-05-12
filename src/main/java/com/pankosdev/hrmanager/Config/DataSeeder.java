package com.pankosdev.hrmanager.Config;

import com.pankosdev.hrmanager.Entities.AcademicInstitution;
import com.pankosdev.hrmanager.Entities.Language;
import com.pankosdev.hrmanager.Entities.LanguageProficiency;
import com.pankosdev.hrmanager.Entities.Skill;
import com.pankosdev.hrmanager.Repositories.AcademicInstitutionRepository;
import com.pankosdev.hrmanager.Repositories.LanguageProficiencyRepository;
import com.pankosdev.hrmanager.Repositories.LanguageRepository;
import com.pankosdev.hrmanager.Repositories.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final LanguageRepository languageRepository;
    private final LanguageProficiencyRepository proficiencyRepository;
    private final SkillRepository skillRepository;
    private final AcademicInstitutionRepository institutionRepository;

    public DataSeeder(
            LanguageRepository languageRepository,
            LanguageProficiencyRepository proficiencyRepository,
            SkillRepository skillRepository,
            AcademicInstitutionRepository institutionRepository
    ) {
        this.languageRepository = languageRepository;
        this.proficiencyRepository = proficiencyRepository;
        this.skillRepository = skillRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public void run(String... args) {

        seedLanguages();
        seedProficiencies();
        seedSkills();
        seedInstitutions();

        System.out.println("Initial data seeding completed.");
    }

    private void seedLanguages() {

        List<String> languages = List.of(
                "Español",
                "Guaraní",
                "Inglés",
                "Portugués",
                "Chino",
                "Japonés",
                "Francés",
                "Alemán",
                "Coreano",
                "Ruso",
                "Árabe",
                "Turco",
                "Italiano"
        );

        for (String name : languages) {

            if (!languageRepository.existsByName(name)) {

                Language language = new Language();
                language.setName(name);

                languageRepository.save(language);
            }
        }
    }

    private void seedProficiencies() {

        List<String> proficiencies = List.of(
                "Nativo",
                "Avanzado",
                "Intermedio",
                "Básico"
        );

        for (String description : proficiencies) {

            if (!proficiencyRepository.existsByDescription(description)) {

                LanguageProficiency proficiency =
                        new LanguageProficiency();

                proficiency.setDescription(description);

                proficiencyRepository.save(proficiency);
            }
        }
    }
    private void seedSkills() {

        List<String> skills = List.of(

                // Programación
                "Java",
                "Spring Boot",
                "React",
                "Oracle",
                "SQL",
                "PostgreSQL",
                "JavaScript",
                "TypeScript",
                "Git",
                "Docker",

                // Contaduría
                "Contabilidad",
                "Auditoría",
                "Excel",
                "Impuestos",
                "Balance General",

                // Recursos Humanos
                "Reclutamiento",
                "Entrevistas",
                "Payroll",
                "Capacitación",
                "Gestión de Talento",

                // Ciencia
                "Análisis de Datos",
                "Investigación",
                "Estadística",
                "Python",

                // Economía
                "Macroeconomía",
                "Microeconomía",
                "Finanzas",
                "Análisis Financiero",

                // Gerente
                "Liderazgo",
                "Gestión de Proyectos",
                "Planificación Estratégica",
                "Comunicación"
        );

        for (String name : skills) {

            if (!skillRepository.existsByName(name)) {

                Skill skill = new Skill();
                skill.setName(name);

                skillRepository.save(skill);
            }
        }
    }

    private void seedInstitutions() {

        createInstitutionIfNotExists(
                "Universidad Nacional de Asunción",
                "UNA",
                "Paraguay",
                "Luque",
                null
        );

        createInstitutionIfNotExists(
                "Universidad Católica",
                "UCA",
                "Paraguay",
                "Asunción",
                null
        );

        createInstitutionIfNotExists(
                "Universidad Politécnica Taiwán Paraguay",
                "UPTP",
                "Paraguay",
                "Asunción",
                null
        );

        createInstitutionIfNotExists(
                "National Taiwan University of Science and Technology",
                "NTUST",
                "Taiwán",
                "Taipei",
                "https://www.ntust.edu.tw/"
        );
    }

    private void createInstitutionIfNotExists(
            String name,
            String abbreviation,
            String country,
            String city,
            String website
    ) {

        if (!institutionRepository.existsByName(name)) {

            AcademicInstitution institution =
                    new AcademicInstitution();

            institution.setName(name);
            institution.setAbbreviation(abbreviation);
            institution.setCountry(country);
            institution.setCity(city);
            institution.setWebsite(website);

            institutionRepository.save(institution);
        }
    }
    
}
