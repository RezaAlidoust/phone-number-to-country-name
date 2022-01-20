package com.gegidze.countrycodeserver.controller;

import com.gegidze.countrycodeserver.dto.CountryCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CountryCodeApi {

    @GetMapping("/{phoneNumber}")
    CountryCodeResponse get(@PathVariable String phoneNumber);
}
