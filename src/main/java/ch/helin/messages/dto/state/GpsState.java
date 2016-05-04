package ch.helin.messages.dto.state;

/**
 * Carries the current static position of the drone and signal quality of the current GPS state.
 */

public class GpsState {

    private GpsQuality fixType;
    private int satellitesCount;
    private double posLat;
    private double posLon;

    public GpsQuality getFixType() {
        return fixType;
    }

    public void setFixType(GpsQuality fixType) {
        this.fixType = fixType;
    }

    public int getSatellitesCount() {
        return satellitesCount;
    }

    public void setSatellitesCount(int satellitesCount) {
        this.satellitesCount = satellitesCount;
    }

    public double getPosLat() {
        return posLat;
    }

    public void setPosLat(double posLat) {
        this.posLat = posLat;
    }

    public double getPosLon() {
        return posLon;
    }

    public void setPosLon(double posLon) {
        this.posLon = posLon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GpsState gpsState = (GpsState) o;

        if (satellitesCount != gpsState.satellitesCount) return false;
        if (Double.compare(gpsState.posLat, posLat) != 0) return false;
        if (Double.compare(gpsState.posLon, posLon) != 0) return false;
        return fixType == gpsState.fixType;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = fixType != null ? fixType.hashCode() : 0;
        result = 31 * result + satellitesCount;
        temp = Double.doubleToLongBits(posLat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(posLon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "GpsState{" +
                "fixType=" + fixType +
                ", satellitesCount=" + satellitesCount +
                ", posLat=" + posLat +
                ", posLon=" + posLon +
                '}';
    }
}
