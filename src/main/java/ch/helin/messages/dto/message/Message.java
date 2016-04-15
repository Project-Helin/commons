package ch.helin.messages.dto.message;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
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
