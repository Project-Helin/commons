package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.way.Route;

/**
 * Created by martin on 14.04.16.
 */
public class AssignMission extends Message{

    private Route route;

    public AssignMission() {
        super(PayloadType.AssignMission);
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
