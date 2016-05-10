package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.MissionDto;
import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

/**
 * Message to assign a drone a specific mission.
 */
public class AssignMissionMessage extends Message{

    private MissionDto mission;

    public AssignMissionMessage() {
        super(PayloadType.AssignMission);
    }

    public MissionDto getMission() {
        return mission;
    }

    public void setMission(MissionDto mission) {
        this.mission = mission;
    }
}
