package com.example.jpaonetomanyopgave.service.Impl;

import com.example.jpaonetomanyopgave.repositories.RegionRepository;
import com.example.jpaonetomanyopgave.service.ApiRegionService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegionServiceImpl implements ApiRegionService {
    private RegionRepository regionRepository;
    private RestTemplate restTemplate;

    public RegionServiceImpl(RegionRepository regionRepository, RestTemplate restTemplate) {
        this.regionRepository = regionRepository;
        this.restTemplate = restTemplate;
    }
}
