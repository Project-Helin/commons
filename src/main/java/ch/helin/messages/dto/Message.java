package ch.helin.messages.dto;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */

public class Message {
    private PayloadType payloadType;
    private MessageType messageType;

    public Message(MessageType messageType, PayloadType payloadType) {
        this.messageType = messageType;
        this.payloadType = payloadType;
    }

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
