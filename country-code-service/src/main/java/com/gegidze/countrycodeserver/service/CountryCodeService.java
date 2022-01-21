package com.gegidze.countrycodeserver.service;

import com.gegidze.countrycodeserver.data.CountryCodesRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryCodeService {
    private final CountryCodesRepository repository;

    CountryCodeService(CountryCodesRepository repository) {
        this.repository = repository;
    }

    public String get(String phoneNumber) {
        repository.get(98);
        return phoneNumber;
    }
}
