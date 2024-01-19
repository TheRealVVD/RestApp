package api.project.rest.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Objects;

@Configuration
public class BeanConfig {
    @Bean
    public XML consumerXML() throws IOException {
        return new XMLDocument(
                Objects.requireNonNull(getClass().getResourceAsStream("/kafka/consumer.xml"))
                        .readAllBytes()
        );
    }
}
