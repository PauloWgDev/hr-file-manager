package com.pankosdev.hrmanager.Controllers;

import com.pankosdev.hrmanager.DOTs.CreateLanguageDTO;
import com.pankosdev.hrmanager.Entities.Language;
import com.pankosdev.hrmanager.Entities.LanguageProficiency;
import com.pankosdev.hrmanager.Services.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    LanguageController(LanguageService languageService)
    {
        this.languageService = languageService;
    }

    @GetMapping
    private List<Language> getAllLanguages()
    {
        return languageService.getAllLanguages();
    }

    @GetMapping("/proficiencies")
    private List<LanguageProficiency> getAllLanguageProficienes()
    {
        return languageService.getAllLanguageProficiencies();
    }

    @PostMapping
    public Language createLanguage(
            @RequestBody CreateLanguageDTO request)
    {
        return languageService.createLanguage(request.getName());
    }
}