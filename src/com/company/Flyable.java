package com.company;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public String getInfo();
}
