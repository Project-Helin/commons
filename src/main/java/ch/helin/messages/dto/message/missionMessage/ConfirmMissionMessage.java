package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

/**
 * Created by martin on 14.04.16.
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
