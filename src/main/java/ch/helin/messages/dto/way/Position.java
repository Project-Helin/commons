package ch.helin.messages.dto.way;

/**
 * Created by martin on 15.04.16.
 */
public class Position {

    private double lat;
    private double lon;
    private double height;

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
}
