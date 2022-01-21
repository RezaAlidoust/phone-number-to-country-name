package com.gegidze.countrycodeserver.service;

import com.gegidze.countrycodeserver.data.CountryCodesRepository;
import com.gegidze.countrycodeserver.entity.CountryCode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class DataService {

    private final CountryCodesRepository repository;

    DataService(CountryCodesRepository countryCodesRepository) {
        this.repository = countryCodesRepository;
    }

    public void saveAll() throws IOException {
        this.repository.saveAll(readCountryCodes());
    }

    private ArrayList<CountryCode> readCountryCodes() throws IOException {
        ArrayList<CountryCode> result = new ArrayList<>();
        //Url is static, no needs to load it from properties
        String url = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";
        Document document = Jsoup.connect(url).get();

        Element tableBody = document
                .getElementById("mw-content-text")
                .getElementsByClass("mw-parser-output")
                .get(0).getElementsByTag("table").get(1)
                .getElementsByTag("tbody").get(0);

        for (Element tr : tableBody.getElementsByTag("tr")) {
            ArrayList<CountryCode> countryCodeDtoArrayList = convertElementToCountryCode(tr);
            result.addAll(countryCodeDtoArrayList);
        }

        return result;
    }

    private ArrayList<CountryCode> convertElementToCountryCode(Element trElement) {
        ArrayList<CountryCode> result = new ArrayList<>();

        if (trElement.getElementsByTag("td").size() == 0)
            return result;
        String countryName = trElement.getElementsByTag("td").get(0).text();

        String codes = trElement.getElementsByTag("td").get(1).getElementsByTag("a").get(0).text().trim();

        for (String code : codes.split(",")) {
            CountryCode dto = new CountryCode();
            dto.setCode(Integer.parseInt(code.replaceAll("[^0-9]", "")));
            dto.setCountry(countryName);
            result.add(dto);
        }

        return result;
    }
}
