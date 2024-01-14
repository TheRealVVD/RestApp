package api.project.rest.controllers;

import api.project.rest.config.ApplicationConfig;
import api.project.rest.dto.SensorDTO;
import api.project.rest.dto.SensorsResponce;
import api.project.rest.models.Sensor;
import api.project.rest.services.SensorService;
import api.project.rest.util.MeasurementErrorResponse;
import api.project.rest.util.MeasurementException;
import api.project.rest.util.SensorNotFoundException;
import api.project.rest.util.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.stream.Collectors;

import static api.project.rest.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorService sensorService;
    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;

    @Autowired
    public SensorsController(SensorService sensorService, ModelMapper modelMapper,
                             SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {
        Sensor sensorToAdd = convertToSensor(sensorDTO);

        sensorValidator.validate(sensorToAdd, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        sensorService.register(sensorToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public SensorsResponce getSensors() {
        return new SensorsResponce(sensorService.findAll().stream().map(this::convertToSensorDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Sensor getSensorById(@PathVariable("id") int id) {
        return sensorService.findById(id).orElseThrow(SensorNotFoundException::new);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    private SensorDTO convertToSensorDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }
}
