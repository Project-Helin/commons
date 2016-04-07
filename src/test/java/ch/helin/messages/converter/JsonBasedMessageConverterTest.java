package ch.helin.messages.converter;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.state.GpsStateMessage;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by martin on 06.04.16.
 */
public class JsonBasedMessageConverterTest {

    @Test
    public void testParseMessageToStringToMessage() throws Exception {
        GpsStateMessage gpsStateMessage = new GpsStateMessage();
        gpsStateMessage.setFixType(3);
        gpsStateMessage.setPosLat(27);
        gpsStateMessage.setPosLon(26);
        gpsStateMessage.setSatellitesCount(5);

        JsonBasedMessageConverter jsonBasedMessageConverter = new JsonBasedMessageConverter();
        String json = jsonBasedMessageConverter.parseMessageToString(gpsStateMessage);

        Message returnMessage = jsonBasedMessageConverter.parseStringToMessage(json);

        //assertThat(gpsStateMessage, IsEqual.equalTo(returnMessage));
        assertThat(gpsStateMessage, IsEqual.equalTo(returnMessage));

    }

}