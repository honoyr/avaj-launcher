package com.company;


public class Main {
//    private static WeatherTower
    public static void main(String[] args) {
	// write your code here

//        WeatherProvider weatherProvider = new WeatherProvider();
        System.out.println("HEllo");
        WeatherTower weatherTower = new WeatherTower();

        weatherTower.setCycle(25);

//        weatherTower.register(AircraftFactory.newAircraft("Helicopter", "H1", 434, 35, 20));
        weatherTower.register(AircraftFactory.newAircraft("Baloon", "B1", 654, 33, 56));
//        weatherTower.register(AircraftFactory.newAircraft("JetPlane", "J1", 954, 83, 40));
//        weatherTower.register(AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20));

        weatherTower.changeWeather();
    }
}
