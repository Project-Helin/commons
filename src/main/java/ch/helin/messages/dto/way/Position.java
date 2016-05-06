package ch.helin.messages.dto.way;


public class Position {

    private double lat;
    private double lon;
    private double height;

    public Position() {
    }

    public Position(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        this.height = 0;
    }

    public Position(double lat, double lon, double height) {
        this.lat = lat;
        this.lon = lon;
        this.height = height;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Position{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", height=" + height +
                '}';
    }

}
