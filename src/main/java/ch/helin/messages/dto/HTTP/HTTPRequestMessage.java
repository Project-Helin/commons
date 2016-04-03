package ch.helin.messages.dto.HTTP;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.ProtocolType;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */
public class HTTPRequestMessage extends Message {
    public HTTPRequestMessage(PayloadType payloadType) {
        super(ProtocolType.HTTP_REQUEST, payloadType);
    }
}
