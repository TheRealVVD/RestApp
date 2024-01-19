package api.project.rest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    //   bin/windows/zookeeper-server-start.bat config/zookeeper.properties
    //   bin/windows/kafka-server-start.bat config/server.properties
    //   bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic NSK --from-beginning
}
