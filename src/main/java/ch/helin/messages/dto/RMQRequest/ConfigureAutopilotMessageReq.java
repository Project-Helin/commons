package ch.helin.messages.dto.RMQRequest;

import ch.helin.messages.dto.DestinationType;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.RMQ.RMQRequestMessage;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by styp on 06.04.16.
 */
public class ConfigureAutopilotMessageReq extends RMQRequestMessage {
    private List<Point2D> waypoints = new LinkedList<>();
    private DestinationType destinationType;


    public ConfigureAutopilotMessageReq(PayloadType payloadType) {
        super(PayloadType.ConfigureAutopilotReq);    }

    public List<Point2D> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Point2D> waypoints) {
        this.waypoints = waypoints;
    }


    public DestinationType getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(DestinationType destinationType) {
        this.destinationType = destinationType;
    }


}
