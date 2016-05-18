package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

public class FinishedMissionMessage extends Message {

    private MissionFinishedType finishedType;

    public FinishedMissionMessage() {
        super(PayloadType.FinishedMission);
    }

    public MissionFinishedType getFinishedType() {
        return finishedType;
    }

    public void setFinishedType(MissionFinishedType finishedType) {
        this.finishedType = finishedType;
    }
}
