package com.example.jpaonetomanyopgave.service.Impl;

import com.example.jpaonetomanyopgave.model.Kommune;
import com.example.jpaonetomanyopgave.model.KommuneNamesDTO;
import com.example.jpaonetomanyopgave.model.Region;
import com.example.jpaonetomanyopgave.repositories.RegionRepository;
import com.example.jpaonetomanyopgave.service.ApiRegionService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public List<Region> findRegionByNameOrCode(String foo) {
        return regionRepository.findRegionsByNameOrCode(foo);
    }

    @Override
    public Optional<Region> findRegionOnlyBySpecificCode(String foo) {
        return regionRepository.findById(foo);
    }

    @Override
    public Region createRegion(Region newRegion) {
        return regionRepository.save(newRegion);
    }

    @Override
    public Optional<Region> updateRegion(String code, Region updateRegion) {
        Optional<Region> region = regionRepository.findById(code);
        if(region.isPresent()) {
            updateRegion.setKode(code);
            return Optional.of(regionRepository.save(updateRegion));
        }
        return Optional.empty();
    }

    @Override
    public String deleteRegion(String code) {
        Optional<Region> region = regionRepository.findById(code);
        if(region.isPresent()) {
            regionRepository.delete(region.get());
            return "Region # " + code + " has been deleted.";
        }
        return "Region # " + code + " was not found and could not be deleted.";
    }

    @Override
    public Optional<KommuneNamesDTO> kommuneNames(String code) {
        Optional<Region> region  = regionRepository.findById(code);
        if(region.isPresent()) {
            return Optional.of(new KommuneNamesDTO(region.get().getKommuneSet()));
        }
        return Optional.empty();
    }


}
