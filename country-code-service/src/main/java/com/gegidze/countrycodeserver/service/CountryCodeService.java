package com.gegidze.countrycodeserver.service;

import org.springframework.stereotype.Service;

@Service
public class CountryCodeService {

    public String get(String phoneNumber) {
        return phoneNumber;
    }
}
