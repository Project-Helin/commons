package ch.helin.messages.dto.RMQBroadcast;


import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.RMQ.RMQBroadcastMessage;
import ch.helin.messages.dto.RMQ.RMQMessage;

/**
 * Created by styp on 03.04.16.
 */
public class GpsStateMessage extends RMQBroadcastMessage {

    private int fixType;
    private int satellitesCount;
    private double posLat;
    private double posLon;

    public GpsStateMessage() {
        super(PayloadType.GpsState);
    }


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
}
