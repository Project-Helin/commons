package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.way.RouteWaypoint;

/**
 * Created by martin on 14.04.16.
 */
public class NotifyCargoDrop extends Message{

    private RouteWaypoint routeWaypoint;

    public NotifyCargoDrop() {
        super(PayloadType.NotifyCargoDrop);
    }

    public RouteWaypoint getRouteWaypoint() {
        return routeWaypoint;
    }

    public void setRouteWaypoint(RouteWaypoint routeWaypoint) {
        this.routeWaypoint = routeWaypoint;
    }
}
