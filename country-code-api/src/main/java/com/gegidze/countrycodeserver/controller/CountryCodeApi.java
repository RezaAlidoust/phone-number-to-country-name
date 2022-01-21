package com.gegidze.countrycodeserver.controller;

import com.gegidze.countrycodeserver.dto.CountryCodeResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Validated
public interface CountryCodeApi {

    @GetMapping("/{phoneNumber}")
    CountryCodeResponse get(@PathVariable
                            @Size(min = 14, max = 14, message = "Length must be 14")
                            @Digits(integer = 14, fraction = 0, message = "All characters must be digits 0 to 9")
                            @Pattern(regexp = "0{2}[1-9]\\d*", message = "It must start with 00 and then non zero digits for example: 001") String phoneNumber);
}
