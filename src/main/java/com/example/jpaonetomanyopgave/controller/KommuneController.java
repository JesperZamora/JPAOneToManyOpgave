package com.example.jpaonetomanyopgave.controller;

import com.example.jpaonetomanyopgave.service.ApiKommuneService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KommuneController {
    private ApiKommuneService kommuneService;

    public KommuneController(ApiKommuneService kommuneService) {
        this.kommuneService = kommuneService;
    }

    // TODO Endpoints - in assignment 1.::
    // TODO getKommuner


}
