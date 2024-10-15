package com.example.FirstTask.service.impl;

import com.example.FirstTask.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class QuoteServiceImpl implements QuoteService {
    private final RestTemplate restTemplate;

    @Autowired
    public QuoteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public ResponseEntity<String> getQuote() {
        String url = "https://ron-swanson-quotes.herokuapp.com/v2/quotes";
        ResponseEntity<String[]> response = restTemplate.getForEntity(url, String[].class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null && response.getBody().length > 0) {
            return ResponseEntity.ok(response.getBody()[0]);
        } else {
            return ResponseEntity.status(500).body("Error retrieving quote");
        }
    }
}
