package ch.helin.messages.dto.state;

public class GPSState {

    private int fixType;
    private int satellitesCount;
    private double posLat;
    private double posLon;

    public int getFixType() {
        return fixType;
    }

    public void setFixType(int fixType) {
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

        GPSState gpsState = (GPSState) o;

        if (fixType != gpsState.fixType) return false;
        if (satellitesCount != gpsState.satellitesCount) return false;
        if (Double.compare(gpsState.posLat, posLat) != 0) return false;
        return Double.compare(gpsState.posLon, posLon) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = fixType;
        result = 31 * result + satellitesCount;
        temp = Double.doubleToLongBits(posLat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(posLon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
