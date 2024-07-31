package org.example.Exceptions.SensorsAndTemperatures;

public interface Sensor {
    boolean isOn();
    void setOn();
    void setOff();
    int read();
}
