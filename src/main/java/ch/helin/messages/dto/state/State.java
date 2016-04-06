package ch.helin.messages.dto.state;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.MessageType;
import ch.helin.messages.dto.PayloadType;

public class State extends Message {
    public State(PayloadType payloadType) {
        super(MessageType.State, payloadType);
    }
}