package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

/**
 * Message to be send, as soon as Drone-Operator has loaded the cargo and confirms it on the display.
 */
public class ConfirmCargoLoaded extends Message{

    public ConfirmCargoLoaded() {
        super(PayloadType.ConfirmCargoLoaded);
    }

}
