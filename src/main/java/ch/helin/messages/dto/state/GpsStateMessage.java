package ch.helin.messages.dto.state;


import ch.helin.messages.dto.PayloadType;


public class GpsStateMessage extends State {

    private GPSState gpsState;

    public GpsStateMessage() {
        super(PayloadType.GpsState);
    }


    public GPSState getGpsState() {
        return gpsState;
    }

    public void setGpsState(GPSState gpsState) {
        this.gpsState = gpsState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GpsStateMessage that = (GpsStateMessage) o;

        return gpsState != null ? gpsState.equals(that.gpsState) : that.gpsState == null;

    }

    @Override
    public int hashCode() {
        return gpsState != null ? gpsState.hashCode() : 0;
    }

}
