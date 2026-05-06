package com.pankosdev.hrmanager.Services;

import com.pankosdev.hrmanager.Entities.Candidate;
import com.pankosdev.hrmanager.Repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;


    public CandidateService(CandidateRepository candidateRepository)
    {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates()
    {
        return candidateRepository.findAll();
    }
}
