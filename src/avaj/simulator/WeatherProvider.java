package avaj.simulator;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        Random rand = new Random();
//        int index = (coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4;
//        System.out.println("MY RANDOM GEN = " + index);
        int index = rand.nextInt(4);
//        System.out.println("RANDOM GEN  = " + index);
//        System.out.println(this.weather[index]);

        return this.weather[index];
    }
}
