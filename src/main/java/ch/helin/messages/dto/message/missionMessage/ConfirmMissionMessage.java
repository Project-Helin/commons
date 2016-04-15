package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

/**
 * Message to accept or deny a mission - sent after drone operator interaction with on-board-app
 */
public class ConfirmMissionMessage extends Message{

    private MissionConfirmType missionConfirmType;

    public ConfirmMissionMessage() {
        super(PayloadType.ConfirmMission);
    }

    public MissionConfirmType getMissionConfirmType() {
        return missionConfirmType;
    }

    public void setMissionConfirmType(MissionConfirmType missionConfirmType) {
        this.missionConfirmType = missionConfirmType;
    }
}
