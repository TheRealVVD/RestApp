package api.project.rest.repositories;

import api.project.rest.models.Measurement;

public interface KafkaDataService {

    void handle(Measurement measurement);

}
