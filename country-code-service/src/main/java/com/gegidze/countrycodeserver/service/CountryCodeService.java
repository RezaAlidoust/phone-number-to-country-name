package com.gegidze.countrycodeserver.service;

import com.gegidze.countrycodeserver.data.CountryCodesRepository;
import org.springframework.stereotype.Service;

import static com.gegidze.countrycodeserver.helper.Helper.convertIntToDigitArray;

@Service
public class CountryCodeService {
    private final CountryCodesRepository repository;

    CountryCodeService(CountryCodesRepository repository) {
        this.repository = repository;
    }

    public String get(String phoneNumber) {
        return repository.get(convertIntToDigitArray(Long.parseLong(phoneNumber)));
    }
}
