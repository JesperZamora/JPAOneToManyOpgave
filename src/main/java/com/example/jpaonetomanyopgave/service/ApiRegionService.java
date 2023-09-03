package com.example.jpaonetomanyopgave.service;

import com.example.jpaonetomanyopgave.model.KommuneNamesDTO;
import com.example.jpaonetomanyopgave.model.Region;

import java.util.List;
import java.util.Optional;

public interface ApiRegionService {

    List<Region> fetchRegions();

    List<Region> findRegionByNameOrCode(String foo);

    Optional<?> findRegionOnlyBySpecificCode(String foo);

    Region createRegion(Region region);

    Optional<Region> updateRegion(String id, Region region);

    String deleteRegion(String code);
    Optional<KommuneNamesDTO> kommuneNames(String code);

    List<String> kommuneNames1(String code);
}
