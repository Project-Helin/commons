package ch.helin.messages.dto.RMQBroadcast;


import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.RMQ.RMQMessage;

/**
 * Created by styp on 03.04.16.
 */
public class GpsStateMessage extends RMQMessage {

    private int fixType;
    private int satellitesCount;
    private double posLat;
    private double posLon;

    public GpsStateMessage() {
        super(PayloadType.GpsState);
    }


}
