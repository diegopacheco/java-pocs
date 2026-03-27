package com.github.diegopacheco.es.config;

import com.github.diegopacheco.es.es.IndexService;
import com.github.diegopacheco.es.es.WindowState;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Component
public class WindowStateInitializer implements ApplicationRunner {

    private final IndexService indexService;
    private final ElasticsearchConfig config;
    private final WindowState windowState;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy_MM_dd");

    public WindowStateInitializer(IndexService indexService, ElasticsearchConfig config, WindowState windowState) {
        this.indexService = indexService;
        this.config = config;
        this.windowState = windowState;
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            Set<String> existing = indexService.getExistingIndexes();
            LocalDate latest = LocalDate.now();
            for (String idx : existing) {
                try {
                    String datePart = idx.substring(config.getIndexPrefix().length() + 1);
                    LocalDate idxDate = LocalDate.parse(datePart, FORMATTER);
                    if (idxDate.isAfter(latest)) {
                        latest = idxDate;
                    }
                } catch (Exception ignored) {}
            }
            windowState.setWindowEnd(latest);
        } catch (Exception ignored) {}
    }
}
