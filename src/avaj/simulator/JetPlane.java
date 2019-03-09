package avaj.simulator;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions(LogFile file) {
        String weather = weatherTower.getWeather(coordinates);

        System.out.print(getInfo());
        file.AddToFile(getInfo());
        switch(weather){
            case "SUN":
            {
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.println("My rotor is going to freeze!");
                file.AddToFile("My rotor is going to freeze!\n");
                break;
            }
            case "RAIN":{
                coordinates.setLatitude(coordinates.getLongitude() + 5);
                System.out.println("It's raining. Better watch out for lightings");
                file.AddToFile("It's raining. Better watch out for lightings\n");
                break;
            }


            case "FOG": {
                coordinates.setLatitude(coordinates.getLongitude() + 1);
                System.out.println("OMG! It's like a milk. I hate the fog.");
                file.AddToFile("OMG! It's like milk. I hate the fog.\n");
                break;
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 7);
                System.out.println("OMG! Winter is coming!");
                file.AddToFile("OMG! Winter is coming!\n");
                break;
            }
        }
        if (coordinates.getHeight() == 0)
        {
            System.out.println(getInfo() + land());
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
