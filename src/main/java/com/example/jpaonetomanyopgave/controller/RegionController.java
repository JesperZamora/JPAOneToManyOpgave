package com.example.jpaonetomanyopgave.controller;

import com.example.jpaonetomanyopgave.service.ApiRegionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController {
    private ApiRegionService regionService;
    public RegionController(ApiRegionService regionService) {
        this.regionService = regionService;
    }

    // TODO Endpoints - in assignment 1.::
    // TODO getRegions

    // TODO postRegions

    // TODO putRegions

    // TODO deleteRegions



    // TODO Endpoint - in assignment 2.::
    // TODO getKommuneNamesByRegionCode
}
