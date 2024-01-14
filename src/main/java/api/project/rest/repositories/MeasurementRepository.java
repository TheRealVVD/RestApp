package api.project.rest.repositories;

import api.project.rest.models.Measurement;
import api.project.rest.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    List<Measurement> findByValueGreaterThan(Double value);
}
