package com.example.jpaonetomanyopgave.controller;

import com.example.jpaonetomanyopgave.model.Region;
import com.example.jpaonetomanyopgave.service.ApiRegionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionController {
    private ApiRegionService regionService;
    public RegionController(ApiRegionService regionService) {
        this.regionService = regionService;
    }

    // TODO Endpoints - in assignment 1.::
    // TODO getAllRegions
    @GetMapping("/regions")
    public List<Region> getAllRegions() {
        List<Region> regionList = regionService.fetchRegions();
        return regionList;
    }

    // TODO getAllRegions - get all by name, code or just some part of the name or kode.
    @GetMapping("/regions/{foo}")
    public List<Region> getAllByNameOrCode(@PathVariable String foo) {
        List<Region> regionList = regionService.findRegionByNameOrCode(foo);
        return regionList;
    }

    // TODO postRegions
    @PostMapping("/regions/add")
    public Region createRegion(@RequestBody Region newRegion) {
        return regionService.createRegion(newRegion);
    }

    // TODO putRegions
    @PutMapping("/regions/{code}/edit")
    public Object updateRegion(@PathVariable String code, @RequestBody Region newRegion) {
        return regionService.updateRegion(code, newRegion);
    }

    // TODO deleteRegions
    @DeleteMapping("/regions/{code}/delete")
    public String deleteRegion(@PathVariable String code) {
        return regionService.deleteRegion(code);
    }


    // TODO Endpoint - in assignment 2.::
    // TODO getKommuneNamesByRegionCode
    @GetMapping("/kommunenavne/{code}")
    public List<String> getKommuneNamesByRegionCode(@PathVariable String code) {
        return null;
    }
 }
