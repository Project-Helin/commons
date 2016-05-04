package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.way.RouteDto;

/**
 * Message to assign a drone a specific mission.
 */
public class AssignMissionMessage extends Message{

    private RouteDto routeDto;

    public AssignMissionMessage() {
        super(PayloadType.AssignMission);
    }

    public RouteDto getRouteDto() {
        return routeDto;
    }

    public void setRouteDto(RouteDto routeDto) {
        this.routeDto = routeDto;
    }
}
