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
}
