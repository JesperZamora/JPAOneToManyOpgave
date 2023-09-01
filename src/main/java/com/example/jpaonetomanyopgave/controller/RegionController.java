package com.example.jpaonetomanyopgave.controller;

import com.example.jpaonetomanyopgave.service.ApiRegionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController {
    private ApiRegionService regionService;
    public RegionController(ApiRegionService regionService) {
        this.regionService = regionService;
    }
}
