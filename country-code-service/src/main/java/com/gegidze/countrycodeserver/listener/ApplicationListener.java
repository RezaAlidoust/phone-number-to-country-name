package com.gegidze.countrycodeserver.listener;

import com.gegidze.countrycodeserver.service.DataService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationListener {

    private final DataService dataService;

    ApplicationListener(DataService dataService) {
        this.dataService = dataService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws IOException {
        dataService.saveAll();
    }
}
