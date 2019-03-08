package com.company;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);

        System.out.print(getInfo());
        switch(weather){
            case "SUN":
            {
                coordinates.setLongitude(coordinates.getLatitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);

                System.out.println("Good weather for fly. Let's enjoy the good weather and take some pics.");
                break ;
            }
            case "RAIN": {
                coordinates.setHeight(coordinates.getHeight() - 5);
                System.out.println("Damn you rain! You messed up my baloon.");
                break ;
            }
            case "FOG": {
                coordinates.setHeight(coordinates.getHeight() - 3);
                System.out.println("OMG! I'm like a big cherry in the sky. I don't see any");
                break ;
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 15);
                System.out.println("It's snowing. We're  gonna crash.");
                break ;
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