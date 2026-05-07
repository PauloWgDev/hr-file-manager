package com.pankosdev.hrmanager.Controllers;

import com.pankosdev.hrmanager.DOTs.CandidateUploadDTO;
import com.pankosdev.hrmanager.DOTs.responses.CandidateResponseDTO;
import com.pankosdev.hrmanager.Entities.Candidate;
import com.pankosdev.hrmanager.Services.CandidateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<CandidateResponseDTO> getAllCandidates()
    {
        return candidateService.getAllCandidates();
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Candidate uploadCandidate(
            @RequestPart("candidate")
            CandidateUploadDTO candidateDTO,

            @RequestPart("file")
            MultipartFile file
    ) throws IOException {

        return candidateService.uploadCandidate(candidateDTO, file);
    }

    @GetMapping("/search")
    public List<CandidateResponseDTO> searchCandidates(

            @RequestParam(required = false)
            String name,

            @RequestParam(required = false)
            String profession,

            @RequestParam(required = false)
            List<String> skills,

            @RequestParam(required = false)
            String language
    ) {

        return candidateService.searchCandidates(
                name,
                profession,
                skills,
                language
        );
    }
}
