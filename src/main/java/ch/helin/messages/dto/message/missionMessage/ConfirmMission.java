package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

/**
 * Created by martin on 14.04.16.
 */
public class ConfirmMission extends Message{
    public ConfirmMission() {
        super(PayloadType.ConfirmMission);
    }
}
