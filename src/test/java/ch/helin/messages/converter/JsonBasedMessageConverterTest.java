package ch.helin.messages.converter;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.state.GPSState;
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
        GPSState gpsState = new GPSState();
        gpsState.setFixType(3);
        gpsState.setPosLat(27);
        gpsState.setPosLon(26);
        gpsState.setSatellitesCount(5);

        GpsStateMessage gpsStateMessage = new GpsStateMessage();
        gpsStateMessage.setGpsState(gpsState);

        JsonBasedMessageConverter jsonBasedMessageConverter = new JsonBasedMessageConverter();
        String json = jsonBasedMessageConverter.parseMessageToString(gpsStateMessage);

        Message returnMessage = jsonBasedMessageConverter.parseStringToMessage(json);

        //assertThat(gpsStateMessage, IsEqual.equalTo(returnMessage));
        assertThat(gpsStateMessage, IsEqual.equalTo(returnMessage));

    }

}