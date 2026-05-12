package com.pankosdev.hrmanager.Services;

import com.pankosdev.hrmanager.DOTs.CreateLanguageDTO;
import com.pankosdev.hrmanager.Entities.Language;
import com.pankosdev.hrmanager.Entities.LanguageProficiency;
import com.pankosdev.hrmanager.Repositories.LanguageProficiencyRepository;
import com.pankosdev.hrmanager.Repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageProficiencyRepository languageProficiencyRepository;

    public LanguageService(LanguageRepository languageRepository, LanguageProficiencyRepository languageProficiencyRepository)
    {
        this.languageRepository = languageRepository;
        this.languageProficiencyRepository = languageProficiencyRepository;
    }

    public List<Language> getAllLanguages()
    {
        List<Language> languages = languageRepository.findAll();
        return languages;
    }

    public List<LanguageProficiency> getAllLanguageProficiencies()
    {
        List<LanguageProficiency> proficiencies = languageProficiencyRepository.findAll();
        return proficiencies;
    }

    public Language createLanguage(String name)
    {
        Language language = new Language();

        language.setName(name);

        return languageRepository.save(language);
    }
}
