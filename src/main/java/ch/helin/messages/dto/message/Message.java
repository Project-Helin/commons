package ch.helin.messages.dto.message;

/**
 * Wrapper class, to easier encode and decode JSONs.
 */

public class Message {
    private PayloadType payloadType;

    public Message(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }
}
