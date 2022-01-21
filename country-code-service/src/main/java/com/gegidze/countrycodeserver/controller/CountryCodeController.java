package com.gegidze.countrycodeserver.controller;

import com.gegidze.countrycodeserver.dto.CountryCodeResponse;
import com.gegidze.countrycodeserver.service.CountryCodeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryCodeController implements CountryCodeApi {

    private CountryCodeService countryCodeService;

    CountryCodeController(CountryCodeService countryCodeService) {
        this.countryCodeService = countryCodeService;
    }

    @Override
    public CountryCodeResponse get(String phoneNumber) {
        phoneNumber = phoneNumber.substring(2, 14);
        String countryName = countryCodeService.get(phoneNumber);
        return new CountryCodeResponse(countryName);
    }
}
