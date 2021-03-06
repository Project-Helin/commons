package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.MissionDto;
import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

/**
 * After the drone Operator accepted the with ConfirmMissionMessage,
 * the server has to Confirm the mission again, in order to know that
 * the server hasn't reasigned the mission to an other drone in the meantime.
 */
public class FinalAssignMissionMessage extends Message {
    private MissionDto mission;

    public FinalAssignMissionMessage() {
        super(PayloadType.FinalAssignMission);
    }

    public MissionDto getMission() {
        return mission;
    }

    public void setMission(MissionDto mission) {
        this.mission = mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinalAssignMissionMessage)) return false;

        FinalAssignMissionMessage that = (FinalAssignMissionMessage) o;

        return mission != null ? mission.equals(that.mission) : that.mission == null;

    }

    @Override
    public int hashCode() {
        return mission != null ? mission.hashCode() : 0;
    }
}
