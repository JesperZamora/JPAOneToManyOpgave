package com.example.jpaonetomanyopgave.service.Impl;

import com.example.jpaonetomanyopgave.repositories.KommuneRepository;
import com.example.jpaonetomanyopgave.service.ApiKommuneService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KommuneServiceImpl implements ApiKommuneService {
    private KommuneRepository kommuneRepository;
    private RestTemplate restTemplate;

    public KommuneServiceImpl(KommuneRepository kommuneRepository, RestTemplate restTemplate) {
        this.kommuneRepository = kommuneRepository;
        this.restTemplate = restTemplate;
    }
}
