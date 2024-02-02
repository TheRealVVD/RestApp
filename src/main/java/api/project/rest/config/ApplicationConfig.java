package api.project.rest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class ApplicationConfig {

    @PostConstruct
    public void init() {
        log.warn("App is working");
    }
}
