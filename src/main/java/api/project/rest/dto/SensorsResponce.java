package api.project.rest.dto;

import java.util.List;

public class SensorsResponce {

    private List<SensorDTO> sensors;

    public SensorsResponce(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }

    public List<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }

}
