package com.company;

public interface Flyable {
    public void updateConditions(LogFile file);
    public void registerTower(WeatherTower weatherTower);
    public String getInfo();
}
