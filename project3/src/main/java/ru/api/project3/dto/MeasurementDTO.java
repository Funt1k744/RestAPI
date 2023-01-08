package ru.api.project3.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import ru.api.project3.models.Sensor;

public class MeasurementDTO {

    @Min(value = -100, message = "")
    @Max(value = 100, message = "")
    private double value;

    private boolean raining;

    private SensorDTO sensor;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
