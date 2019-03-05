import weather.WeatherProvider;

public class AirCraftimulation {

    public static void main(String[] args){

        WeatherProvider weatherProvider = new WeatherProvider();

        WeatherTower weatherTower = new WeatherTower();

//        weatherTower.getWeather(654, 33, 20);

        AircraftFactory aircraftFactory = new AircraftFactory();

//        Flyable flyable = new Flyable();

//        aircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20);

//        Aircraft Helicopter =

        weatherTower.register(aircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20));
    }
}
