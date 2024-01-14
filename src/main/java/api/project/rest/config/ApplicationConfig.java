package api.project.rest.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class ApplicationConfig {

//    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    @PostConstruct
    public void init() {
        log.warn("App is working");
    }
}
