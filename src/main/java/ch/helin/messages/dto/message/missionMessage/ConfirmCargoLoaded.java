package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;

/**
 * Created by martin on 14.04.16.
 */
public class ConfirmCargoLoaded extends Message{

    public ConfirmCargoLoaded() {
        super(PayloadType.ConfirmCargoLoaded);
    }

}
