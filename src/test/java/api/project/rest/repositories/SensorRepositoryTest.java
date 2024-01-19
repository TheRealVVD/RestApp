package api.project.rest.repositories;

import api.project.rest.IntegrationTestBase;
import api.project.rest.models.Sensor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SensorRepositoryTest extends IntegrationTestBase {

    @Autowired
    private SensorRepository sensorRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testFindById() {
        Optional<Sensor> sensor = sensorRepository.findById(1);
        assertTrue(sensor.isPresent());
        sensor.ifPresent(x -> assertEquals("test3", x.getName()));
    }

    @Test
    void testSave() {
        Sensor sensor = Sensor.builder().name("asdd").build();
        sensorRepository.save(sensor);
        assertNotNull(sensorRepository.findByName("asdd").get().getId());
    }

    @Test
    void testFindByNameContaining() {
        Optional<Sensor> sensor = sensorRepository.findByNameContaining("RK");
        assertTrue(sensor.isPresent());
    }
}