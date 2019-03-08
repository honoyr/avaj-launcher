package com.company;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
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
                System.out.println("My rotor is going to freeze!");
                break;
            }
            case "RAIN":{
                coordinates.setLatitude(coordinates.getLongitude() + 5);
                System.out.println("It's raining. Better watch out for lightings");
                break;
            }


            case "FOG": {
                coordinates.setLatitude(coordinates.getLongitude() + 1);
                System.out.println("OMG! It's like a milk. I hate the fog.");
                break;
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 7);
                System.out.println("OMG! Winter is coming!");
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
