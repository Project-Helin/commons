package ch.helin.messages.dto.response;

import ch.helin.messages.dto.PayloadType;

/**
 * Created by styp on 06.04.16.
 */
public class ConfigureAutopilotResponse extends Response {

    private boolean messageRecieved = true;

    public ConfigureAutopilotResponse() {
        super(PayloadType.ConfigureAutopilot);
    }

}
