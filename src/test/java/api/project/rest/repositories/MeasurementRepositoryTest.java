package api.project.rest.repositories;

import api.project.rest.IntegrationTestBase;
import api.project.rest.models.Measurement;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementRepositoryTest extends IntegrationTestBase {

    @Autowired
    private MeasurementRepository measurementRepository;

    @Test
    void testFindById() {
        Optional<Measurement> measurement = measurementRepository.findById(1);
        assertTrue(measurement.isPresent());
    }

    @Test
    void testFindByValueGreater() {
        List<Measurement> measurements = measurementRepository.findByValueGreaterThan(21.0);
        assertFalse(measurements.isEmpty());
    }



}