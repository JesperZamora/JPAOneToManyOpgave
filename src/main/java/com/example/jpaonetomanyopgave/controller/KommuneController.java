package com.example.jpaonetomanyopgave.controller;

import com.example.jpaonetomanyopgave.model.Kommune;
import com.example.jpaonetomanyopgave.service.ApiKommuneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneController {
    private ApiKommuneService kommuneService;

    public KommuneController(ApiKommuneService kommuneService) {
        this.kommuneService = kommuneService;
    }

    // TODO Endpoints - in assignment 1.::
    // TODO getKommuner - fetched directly from the api
    @GetMapping("/kommuner")
    public List<Kommune> getAllKommuner() {
        List<Kommune> kommuneList = kommuneService.fetchKommuner();
        return kommuneList;
    }


}
