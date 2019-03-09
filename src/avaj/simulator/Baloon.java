package avaj.simulator;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    private LogFile file;

    public Baloon(String name, Coordinates coordinates) {

        super(name, coordinates);
        this.file = file;
    }

    @Override
    public void updateConditions(LogFile file) {

        String weather = weatherTower.getWeather(coordinates);

        System.out.print(getInfo());
        file.AddToFile(getInfo());
        switch(weather){
            case "SUN":
            {
                coordinates.setLongitude(coordinates.getLatitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);

                System.out.println("Good weather for fly. Let's enjoy the good weather and take some pics.");
                file.AddToFile("Good weather for fly. Let's enjoy the good weather and take some pics.\n");
                break ;
            }
            case "RAIN": {
                coordinates.setHeight(coordinates.getHeight() - 5);
                System.out.println("Damn you rain! You messed up my baloon.");
                file.AddToFile("Damn you rain! You messed up my baloon.\n");
                break ;
            }
            case "FOG": {
                coordinates.setHeight(coordinates.getHeight() - 3);
                System.out.println("OMG! I'm like a big cherry in the sky. I don't see any");
                file.AddToFile("OMG! I'm like a big cherry in the sky. I don't see anything\n");
                break ;
            }
            case "SNOW": {
                coordinates.setHeight(coordinates.getHeight() - 15);
                System.out.println("It's snowing. We're  gonna crash.");
                file.AddToFile("It's snowing. We're  gonna crash.\n");
                break ;
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