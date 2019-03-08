package com.company;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Exception;
import java.lang.String;

public class Main {

    public static boolean valid_name(String name) {

        switch (name) {
            case "JetPlane":
                return true;
            case "Baloon":
                return true;
            case "Helicopter":
                return true;
        }
        return false;
    }

    public static boolean valid_coordin(int val) {
        if (val >= 0 && val <= 100)
            return true;
        return false;
    }

    public static boolean coordinIsPositive(int val) {
        if (val >= 0)
            return true;
        return false;
    }

    public static String printError(String line){
        String message = "Error: "
                + line.split(" ")[0]
                + "#" + line.split(" ")[1];
        return (message);
    }

    public static int valid_line(String line) {

        int flag = 0;

        if (!valid_name(line.split(" ")[0])) {
            System.out.println(printError(line)
                    + " - Lexical mistake");
            flag++;
        }
        if (!coordinIsPositive(Integer.parseInt(line.split(" ")[2]))) {
            System.out.println(printError(line)
                    + " - Longitude with value \""
                    + Integer.parseInt(line.split(" ")[2])
                    + "\" is invalid, have to be positive.");
            flag++;
        }
        if (!coordinIsPositive(Integer.parseInt(line.split(" ")[3]))) {
            System.out.println(printError(line)
                    + " - Latitude with value \""
                    + Integer.parseInt(line.split(" ")[3])
                    + "\" is invalid, have to be positive.");
            flag++;
        }
            if (!valid_coordin(Integer.parseInt(line.split(" ")[4]))) {
                System.out.println(printError(line)
                        + " - Coordinates with value \""
                        + Integer.parseInt(line.split(" ")[4])
                        + "\" is invalid");
                flag++;
            }
        return flag;
    }

    public static void main (String[] args) {

            try {
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));

                String line = reader.readLine();
                if (line != null) {
                    int cycle = Integer.parseInt(line.split(" ")[0]);
                    if (cycle < 1)
                        System.out.println("Invalid number of cycle - have to be more than 0");
                    else{
                        WeatherTower weatherTower = new WeatherTower(cycle);
                        while ((line = reader.readLine()) != null) {
                            if (valid_line(line) == 0)
                                weatherTower.register(AircraftFactory.newAircraft(
                                        line.split(" ")[0],
                                        line.split(" ")[1],
                                        Integer.parseInt(line.split(" ")[2]),
                                        Integer.parseInt(line.split(" ")[3]),
                                        Integer.parseInt(line.split(" ")[4])));
                        }
                        reader.close();
                        weatherTower.changeWeather();
                    }
                }
                else
                    System.out.println("File is empty.");
            } catch (FileNotFoundException e) {
                System.out.println("File " + args[0] + " not found.");
            } catch (IOException e) {
                System.out.println("File " + args[0] + " couldn't find");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Provide file name, please.");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }



//    WeatherTower weatherTower = new WeatherTower();

//        weatherTower.setCycle(25);
//
//        weatherTower.register(AircraftFactory.newAircraft("Helicopter", "H1", 434, 35, 20));
//        weatherTower.register(AircraftFactory.newAircraft("Baloon", "B1", 654, 33, 56));
//        weatherTower.register(AircraftFactory.newAircraft("JetPlane", "J1", 954, 83, 40));
//        weatherTower.register(AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20));
//
//        weatherTower.changeWeather();