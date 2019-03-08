package com.company;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);

        System.out.print(getInfo());
        switch(weather){
            case "SUN":
            {
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.println("This is hot.");
                break;
            }
            case "RAIN": {
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                System.out.println("This is wet.");
                break;
            }

            case "FOG": {
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                System.out.println("I don't see anything.");
                break;
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 12);
                System.out.println("My rotor is going to freeze!");
                break;
            }
        }
        if (coordinates.getHeight() == 0)
        {
            System.out.print(getInfo());
            land();
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    public void land(){
        System.out.println("Landing. Coordinates: Height = " + coordinates.getHeight()
                + " longitude = " + coordinates.getLongitude()
                + " Latitude = " + coordinates.getLatitude());
    }

    public String getInfo(){
        String messege = this.getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): ";
        return (messege);
    }
}
