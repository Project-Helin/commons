package ch.helin.messages.experimental;

import ch.helin.messages.converter.JsonBasedMessageConverter;
import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.state.GpsStateMessage;

/**
 * Created by styp on 04.04.16.
 */
public class Test {

    public static void main(String[] args) {
        JsonBasedMessageConverter jsonBasedMessageConverter = new JsonBasedMessageConverter();

        GpsStateMessage gpsStateMessage = new GpsStateMessage();
        gpsStateMessage.setFixType(3);
        gpsStateMessage.setSatellitesCount(2);

        String s = jsonBasedMessageConverter.parseMessageToString(gpsStateMessage);

        System.out.println(s);


        Message message = jsonBasedMessageConverter.parseStringToMessage(s);
        System.out.println(message);
    }
}
