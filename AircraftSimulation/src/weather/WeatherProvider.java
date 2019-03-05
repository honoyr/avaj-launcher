package weather;
//package src;

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
        int index = (coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4;
        System.out.println(index);
        index = rand.nextInt(4);

        System.out.println(this.weather[rand]);

        return this.weather[rand];
    }
}
