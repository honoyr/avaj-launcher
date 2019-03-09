package avaj.simulator;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude < 0 ? 0 : longitude;
        this.latitude = latitude < 0 ? 0 : latitude;
        if (height >= 0 && height <= 100)
            this.height = height;
        else
            this.height = height < 0 ? 0 : 100;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    // SETERS
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        if (height >= 0 && height <= 100)
            this.height = height;
        else if (height > 100)
            this.height = 100;
        else
            this.height = 0;
    }
}
