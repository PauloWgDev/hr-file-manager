package com.pankosdev.hrmanager.Controllers;

import com.pankosdev.hrmanager.Entities.Candidate;
import com.pankosdev.hrmanager.Services.CandidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService)
    {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getAllCandidates()
    {
        return candidateService.getAllCandidates();
    }
}
