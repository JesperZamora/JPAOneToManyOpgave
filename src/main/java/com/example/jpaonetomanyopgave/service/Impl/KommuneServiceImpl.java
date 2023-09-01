package com.example.jpaonetomanyopgave.service.Impl;

import com.example.jpaonetomanyopgave.model.Kommune;
import com.example.jpaonetomanyopgave.repositories.KommuneRepository;
import com.example.jpaonetomanyopgave.service.ApiKommuneService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.jpaonetomanyopgave.service.Impl.apiEnum.ApiData.URL_KOMMUNE;

@Service
public class KommuneServiceImpl implements ApiKommuneService {
    private KommuneRepository kommuneRepository;
    private RestTemplate restTemplate;

    public KommuneServiceImpl(KommuneRepository kommuneRepository, RestTemplate restTemplate) {
        this.kommuneRepository = kommuneRepository;
        this.restTemplate = restTemplate;
    }

    private void persistKommuner(List<Kommune> kommuneList) {
        kommuneRepository.saveAll(kommuneList);
    }

    public List<Kommune> fetchKommuner() {
        ResponseEntity<List<Kommune>> apiResponse =
                restTemplate.exchange(URL_KOMMUNE.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>() {});

        List<Kommune> kommuner = apiResponse.getBody();
        persistKommuner(kommuner);

        return kommuner;
    }
}
