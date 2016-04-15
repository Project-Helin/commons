package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.way.Route;


public class AssignMissionMessage extends Message{

    private Route route;

    public AssignMissionMessage() {
        super(PayloadType.AssignMission);
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
