package ch.helin.messages.dto.response;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.MessageType;
import ch.helin.messages.dto.PayloadType;

public class Response extends Message {
    public Response(PayloadType proPayloadType) {
        super(MessageType.Response, proPayloadType);
    }
}