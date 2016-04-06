package ch.helin.messages.dto.request;

import ch.helin.messages.dto.DestinationType;
import ch.helin.messages.dto.PayloadType;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by styp on 06.04.16.
 */
public class ConfigureAutopilotRequest extends Request {

    private List<Point2D> waypoints = new LinkedList<>();
    private DestinationType destinationType;


    public ConfigureAutopilotRequest() {
        super(PayloadType.ConfigureAutopilot);
    }

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
