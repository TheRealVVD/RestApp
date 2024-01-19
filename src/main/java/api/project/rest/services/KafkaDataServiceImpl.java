package api.project.rest.services;


import api.project.rest.models.Measurement;
import api.project.rest.repositories.KafkaDataService;
import api.project.rest.repositories.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final MeasurementRepository measurementRepository;

    @Override
    public void handle(Measurement measurement) {
        log.info("Data object {} was saved", measurement);
        measurementRepository.save(measurement);
    }
}
