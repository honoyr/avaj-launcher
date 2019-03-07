package com.company;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
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
                        + "My rotor is going to freeze!");
            }
            case "RAIN":{
                coordinates.setLatitude(coordinates.getLongitude() + 5);
                System.out.println(this.getClass().getName() + "#" + getName()
                        + "(" + getId() + "):"
                        + "It's raining. Better watch out for lightings");
            }


            case "FOG": {
                coordinates.setLatitude(coordinates.getLongitude() + 1);
                System.out.println(this.getClass().getName() + "#" + getName()
                        + "(" + getId() + "):"
                        + "OMG! It's like a milk. I hate the fog.");
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 7);
                System.out.println(this.getClass().getName() + "#" + getName()
                        + "(" + getId() + "):"
                        + "OMG! Winter is coming!");
            }
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    public String getInfo(){
        String messege = this.getClass().getName() + "#" + getName() + getId();
        return (messege);
    }
}
