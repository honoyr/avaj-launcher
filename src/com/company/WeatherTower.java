//import WeatherProvider;
package com.company;

public class WeatherTower extends Tower {

    private int cycle;

    public WeatherTower() {
    }

    public void WeatherTower(int cycle) {

        this.cycle = cycle;
    }

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        for (int i = 0; i < cycle; i++){
            conditionsChanged();
        }
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    @Override
    public void register(Flyable flyable) {
        super.register(flyable);
        flyable.registerTower(this);
    }

    @Override
    public void unregister(Flyable flyable) {
        super.unregister(flyable);
    }
}