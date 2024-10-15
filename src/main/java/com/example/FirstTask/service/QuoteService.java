package com.example.FirstTask.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface QuoteService {
    ResponseEntity<String> getQuote();
}
