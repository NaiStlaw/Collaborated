package com.example.covitrix;

public class Sensor {
    private String Temperature;
    private String TimeDate;
    private String HeartRate;
    private String SPO2;

    public Sensor(String temperature, String timeDate, String heartRate, String SPO2) {
        Temperature = temperature;
        TimeDate = timeDate;
        HeartRate = heartRate;
        SPO2 = SPO2;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getTimeDate() {
        return TimeDate;
    }

    public void setTimeDate(String timeDate) {
        TimeDate = timeDate;
    }

    public String getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(String heartRate) {
        HeartRate = heartRate;
    }

    public String getSPO2() {
        return SPO2;
    }

    public void setSPO2(String SPO2) {
        this.SPO2 = SPO2;
    }
}
