package com.gegidze.countrycodeserver.controller;

import com.gegidze.countrycodeserver.dto.CountryCodeResponse;
import com.gegidze.countrycodeserver.service.CountryCodeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CountryCodeController implements CountryCodeApi {

    private CountryCodeService countryCodeService;

    CountryCodeController(CountryCodeService countryCodeService) {
        this.countryCodeService = countryCodeService;
    }


    // like phoneNumber = 00123456789123
    @Override
    public CountryCodeResponse get(String phoneNumber) {
        phoneNumber = phoneNumber.substring(2, 14);
        String countryName = countryCodeService.get(phoneNumber);
        return new CountryCodeResponse(countryName);
    }
}
