package ch.helin.messages.dto.RMQRequest;

import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.RMQ.RMQRequestMessage;

/**
 * Created by styp on 06.04.16.
 */
public class ConfirmDeliveryMessageReq extends RMQRequestMessage {
    public ConfirmDeliveryMessageReq(PayloadType payloadType) {
        super(PayloadType.ConfirmDeliveryReq);
    }


}
