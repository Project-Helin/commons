package ch.helin.messages.dto;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */

public class Message {
    private ProtocolType protocolType;
    private PayloadType payloadType;

    public Message(ProtocolType protocolType, PayloadType payloadType) {
        this.protocolType = protocolType;
        this.payloadType = payloadType;
    }

    public ProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }
}
