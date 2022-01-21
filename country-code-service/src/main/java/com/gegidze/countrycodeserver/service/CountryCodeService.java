package com.gegidze.countrycodeserver.service;

import com.gegidze.countrycodeserver.data.CountryCodesRepository;
import com.gegidze.countrycodeserver.exception.NotFoundException;
import org.springframework.stereotype.Service;

import static com.gegidze.countrycodeserver.helper.Helper.convertIntToDigitArray;

@Service
public class CountryCodeService {
    private final CountryCodesRepository repository;

    CountryCodeService(CountryCodesRepository repository) {
        this.repository = repository;
    }

    public String get(String phoneNumber) {
        String country = repository.get(convertIntToDigitArray(Long.parseLong(phoneNumber)));
        if (country == null) {
            throw new NotFoundException("There is no country matches with your phone number");
        }
        return country;
    }
}
