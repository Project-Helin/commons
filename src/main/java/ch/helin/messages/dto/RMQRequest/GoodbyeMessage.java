package ch.helin.messages.dto.RMQRequest;

import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.RMQ.RMQRequestMessage;

/**
 * Created by styp on 06.04.16.
 */
public class GoodbyeMessage extends RMQRequestMessage {
    private boolean goodbye = true;

    public GoodbyeMessage(PayloadType payloadType) {
        super(PayloadType.Goodbye);
    }
}
