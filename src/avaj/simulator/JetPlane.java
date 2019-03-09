package avaj.simulator;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions(LogFile file) {
        String weather = weatherTower.getWeather(coordinates);

        file.AddToFile(getInfo());
        switch(weather){
            case "SUN":
            {
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                file.AddToFile("My rotor is going to freeze!\n");
                break;
            }
            case "RAIN":{
                coordinates.setLatitude(coordinates.getLongitude() + 5);
                file.AddToFile("It's raining. Better watch out for lightings\n");
                break;
            }


            case "FOG": {
                coordinates.setLatitude(coordinates.getLongitude() + 1);
                file.AddToFile("OMG! It's like milk. I hate the fog.\n");
                break;
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 7);
                file.AddToFile("OMG! Winter is coming!\n");
                break;
            }
        }
        if (coordinates.getHeight() == 0)
        {
            file.AddToFile(getInfo());
            file.AddToFile(land());
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    public String land(){
        return ("Landing. Coordinates: Height = " + coordinates.getHeight()
                + " longitude = " + coordinates.getLongitude()
                + " Latitude = " + coordinates.getLatitude() + "\n");
    }

    public String getInfo(){
        String messege = this.getClass().getSimpleName() + "#" + getName() + "(" + getId() + "): ";
        return (messege);
    }
}
