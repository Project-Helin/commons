package ch.helin.messages.dto.request;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.MessageType;
import ch.helin.messages.dto.PayloadType;

public class Request extends Message {
    public Request(PayloadType proPayloadType) {
        super(MessageType.Request, proPayloadType);
    }
}