package com.company;

abstract public class AircraftFactory {

    public AircraftFactory() {
    }

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){


        if(type.compareTo("Helicopter")== 0){

            Coordinates newCordinates = new Coordinates(longitude, latitude, height);
            Helicopter newHelicopter = new Helicopter(name, newCordinates);
            return newHelicopter;
        }
        else if(type.compareTo("JetPlane")== 0){

            Coordinates newCordinates = new Coordinates(longitude, latitude, height);
            JetPlane newJetplane = new JetPlane(name, newCordinates);
            return newJetplane;
        }
        else if(type.compareTo("Baloon")== 0){

            Coordinates newCordinates = new Coordinates(longitude, latitude, height);
            Baloon newBaloon = new Baloon(name, newCordinates);
            return newBaloon;
        }
        return null;
    }
}
