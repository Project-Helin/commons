package ch.helin.messages.converter;

import ch.helin.messages.dto.message.DroneDto;
import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.stateMessage.DroneStateMessage;
import ch.helin.messages.dto.state.DroneState;
import ch.helin.messages.dto.state.GpsQuality;
import ch.helin.messages.dto.state.GpsState;
import ch.helin.messages.dto.message.stateMessage.GpsStateMessage;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.*;


public class JsonBasedMessageConverterTest {

    @Test
    public void testParseMessageToStringToMessage() throws Exception {
        GpsState gpsState = new GpsState();
        gpsState.setFixType(GpsQuality._2D);
        gpsState.setPosLat(27);
        gpsState.setPosLon(26);
        gpsState.setSatellitesCount(5);

        GpsStateMessage gpsStateMessage = new GpsStateMessage();
        gpsStateMessage.setGpsState(gpsState);

        JsonBasedMessageConverter jsonBasedMessageConverter = new JsonBasedMessageConverter();
        String json = jsonBasedMessageConverter.parseMessageToString(gpsStateMessage);

        Message returnMessage = jsonBasedMessageConverter.parseStringToMessage(json);
        
        assertThat(gpsStateMessage, IsEqual.equalTo(returnMessage));
    }

    @Test(expected = CouldNotParseJsonException.class)
    public void couldNotParseJsonMessage() {
        JsonBasedMessageConverter jsonBasedMessageConverter = new JsonBasedMessageConverter();
        jsonBasedMessageConverter.parseStringToMessage("unknown content");

    }

    @Test
    public void testParseDroneState() throws Exception {

        DroneState droneState = new DroneState();
        droneState.setAltitude(12);
        droneState.setIsConnected(true);
        droneState.setGroundSpeed(35);
        droneState.setFirmeware("Ardupilot 3.3");
        droneState.setVerticalSpeed(3);

        DroneStateMessage droneStateMessage = new DroneStateMessage();
        droneStateMessage.setDroneState(droneState);

        JsonNode messageAsJSON = Json.toJson(droneStateMessage);

    }
}