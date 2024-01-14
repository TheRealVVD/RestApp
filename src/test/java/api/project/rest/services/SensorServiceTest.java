package api.project.rest.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class SensorServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindByName() {
        String expected = "фыв";
        assertEquals(expected, "фыв");
    }

    @Test
    void testFindAll() {
    }

    @Test
    void testFindById() {

    }

    @Test
    void testRegister() {

    }
}