import weather.WeatherProvider;

import java.util.ArrayList;

public class WeatherTower extends Tower {

    public WeatherTower() {
    }

    public String getWeather(Coordinates coordinates){


    }

    void changeWeather(){

    }

    @Override
    public void register(Flyable flyable) {
        super.register(flyable);
    }

    @Override
    public void unregister(Flyable flyable) {
        flyable.registerTower(this);
    }

    @Override
    protected void conditionsChanged() {
        super.conditionsChanged();
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
