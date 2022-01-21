package com.gegidze.countrycodeserver.data;

import com.gegidze.countrycodeserver.entity.Node;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Data {

    @Bean
    public Node countryCodesTree() {
        return new Node();
    }
}
