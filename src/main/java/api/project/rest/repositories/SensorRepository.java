package api.project.rest.repositories;

import api.project.rest.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);

    Optional<Sensor> findById(int id);

    Optional<Sensor> findByNameContaining(String namePart);
}
