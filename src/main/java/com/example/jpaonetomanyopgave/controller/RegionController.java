package com.example.jpaonetomanyopgave.controller;

import com.example.jpaonetomanyopgave.model.KommuneNamesDTO;
import com.example.jpaonetomanyopgave.model.Region;
import com.example.jpaonetomanyopgave.service.ApiRegionService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class RegionController {
    private ApiRegionService regionService;
    public RegionController(ApiRegionService regionService) {
        this.regionService = regionService;
    }

    // TODO Endpoints - in assignment 1.::
    // TODO getAllRegions - fetched directly from the api
    @GetMapping("/regioner")
    public ResponseEntity<List<Region>> getAllRegions() {
        return ResponseEntity.ok(regionService.fetchRegions());
    }

    // TODO getAllRegions - get all by name, code or just some part of the name or kode.
    @GetMapping("/regioner/{foo}")
    public ResponseEntity<List<Region>> getAllByNameOrCode(@PathVariable String foo) {
        List<Region> regionList = regionService.findRegionByNameOrCode(foo);

        if(!regionList.isEmpty()) {
            return ResponseEntity.ok(regionList);
        }

        return ResponseEntity.noContent().build();
    }

    // TODO postRegions
    @PostMapping("/regioner/add")
    public ResponseEntity<Region> createRegion(@RequestBody Region newRegion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(regionService.createRegion(newRegion));
    }

    // TODO putRegions
    @PutMapping("/regioner/{code}/edit")
    public ResponseEntity<?> updateRegion(@PathVariable String code, @RequestBody Region newRegion) {
        Optional<?> foo = regionService.updateRegion(code, newRegion);

        if(foo.isPresent()) {
            return ResponseEntity.ok(foo.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region #  " + code + " not found.");
    }

    // TODO deleteRegions
    @DeleteMapping("/regioner/{code}/delete")
    public String deleteRegion(@PathVariable String code) {
        return regionService.deleteRegion(code);
    }


    // TODO Endpoint - in assignment 2.::
    // TODO getKommuneNamesByRegionCode
    @GetMapping("/kommunenavne/{code}")
    public ResponseEntity<?> getKommuneNamesByRegionCode(@PathVariable String code) {
        Optional<KommuneNamesDTO> foo = regionService.kommuneNames(code);
        if(foo.isPresent()) {
            return ResponseEntity.ok(foo.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Region #  " + code + " not found.");
    }
 }
