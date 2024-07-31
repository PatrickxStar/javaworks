package org.example.Exceptions.SensorsAndTemperatures;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn;
    private Random random;

    public TemperatureSensor() {
        this.isOn = false;
        this.random = new Random();
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        if (!this.isOn) {
            throw new IllegalStateException("The sensor is off");
        }
        return this.random.nextInt(61) - 30;
    }
}
