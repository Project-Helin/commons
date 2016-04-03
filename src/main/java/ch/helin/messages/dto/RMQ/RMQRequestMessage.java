package ch.helin.messages.dto.RMQ;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.ProtocolType;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */
public class RMQRequestMessage extends Message{

    public RMQRequestMessage(PayloadType payloadType) {
        super(ProtocolType.RMQ_REQUEST, payloadType);
    }
}
