package com.example.jpaonetomanyopgave.service.Impl;

import com.example.jpaonetomanyopgave.model.Region;
import com.example.jpaonetomanyopgave.repositories.RegionRepository;
import com.example.jpaonetomanyopgave.service.ApiRegionService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.jpaonetomanyopgave.service.Impl.apiEnum.ApiData.URL_REGION;

@Service
public class RegionServiceImpl implements ApiRegionService {
    private RegionRepository regionRepository;
    private RestTemplate restTemplate;

    public RegionServiceImpl(RegionRepository regionRepository, RestTemplate restTemplate) {
        this.regionRepository = regionRepository;
        this.restTemplate = restTemplate;
    }

    private void persistRegions(List<Region> regionList) {
        regionRepository.saveAll(regionList);
    }

    @Override
    public List<Region> fetchRegions() {
        ResponseEntity<List<Region>> apiResponse =
                restTemplate.exchange(URL_REGION.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Region>>() {
        });

        List<Region> regions = apiResponse.getBody();
        persistRegions(regions);

        return regions;
    }
}
