package api.project.rest.services;

import api.project.rest.config.LocalDateTimeDeserializer;
import api.project.rest.models.Measurement;
import api.project.rest.repositories.KafkaDataReceiver;
import api.project.rest.repositories.KafkaDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaDataService kafkaDataService;

    /**
     * Для запуска fetch() при создании приложения
     */
    @PostConstruct
    private void init() {
        fetch();
    }


    @Override
    public void fetch() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        localDateTimeDeserializer)
                .create();

        receiver.receive()
                .subscribe(r -> {
                    Measurement measurement = gson
                            .fromJson(r.value().toString(), Measurement.class);

                    kafkaDataService.handle(measurement);
                    r.receiverOffset().acknowledge();
                });
    }
}
