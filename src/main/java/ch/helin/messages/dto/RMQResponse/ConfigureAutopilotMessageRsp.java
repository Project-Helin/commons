package ch.helin.messages.dto.RMQResponse;

import ch.helin.messages.dto.DestinationType;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.RMQ.RMQResponseMessage;

import javax.print.attribute.standard.Destination;

/**
 * Created by styp on 06.04.16.
 */
public class ConfigureAutopilotMessageRsp extends RMQResponseMessage{

    private boolean messageRecieved = true;

    public ConfigureAutopilotMessageRsp(PayloadType payloadType) {
        super(PayloadType.ConfigureAutopilotRsp);
    }

}
