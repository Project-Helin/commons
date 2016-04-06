package ch.helin.messages.dto.request;

import ch.helin.messages.dto.PayloadType;

/**
 * Created by styp on 06.04.16.
 */
public class GoodbyeRequest extends Request{
    private boolean goodbye = true;

    public GoodbyeRequest() {
        super(PayloadType.Goodbye);
    }
}
