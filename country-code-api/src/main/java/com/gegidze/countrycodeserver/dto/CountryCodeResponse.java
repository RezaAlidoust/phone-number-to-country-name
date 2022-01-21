package com.gegidze.countrycodeserver.dto;

public class CountryCodeResponse {
    private final String country;

    public CountryCodeResponse(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
