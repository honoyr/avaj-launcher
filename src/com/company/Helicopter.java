package com.company;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);

        switch(weather){
            case "SUM":
            {
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.println(this.getClass().getName() + "#" + getName()
                        + "(" + getId() + "):"
                        + "This is hot.");
            }
            case "RAIN": {
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                System.out.println(this.getClass().getName() + "#" + getName()
                        + "(" + getId() + "):"
                        + "This is wet.");
            }

            case "FOG": {
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                System.out.println(this.getClass().getName() + "#" + getName()
                        + "(" + getId() + "):"
                        + "I don't see anything.");
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 12);
                System.out.println(this.getClass().getName() + "#" + getName()
                        + "(" + getId() + "):"
                        + "My rotor is going to freeze!");
            }
        }
    }

    public String getInfo(){
        String messege = this.getClass().getName() + "#" + getName() + getId();
        return (messege);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }
}
