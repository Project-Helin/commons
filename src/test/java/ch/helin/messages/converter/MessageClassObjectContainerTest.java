package ch.helin.messages.converter;

import ch.helin.messages.dto.MessageType;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.request.ConfigureAutopilotRequest;
import ch.helin.messages.dto.request.ConfirmDeliveryRequest;
import ch.helin.messages.dto.request.GoodbyeRequest;
import ch.helin.messages.dto.response.ConfigureAutopilotResponse;
import ch.helin.messages.dto.state.BatteryStateMessage;
import ch.helin.messages.dto.state.DroneStateMessage;
import ch.helin.messages.dto.state.GpsStateMessage;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by martin on 06.04.16.
 */
public class MessageClassObjectContainerTest {

    @Test
    public void testFindBy() throws Exception {

        MessageClassObjectContainer messageClassObjectContainer = new MessageClassObjectContainer();

        Class<?> configureAutopilotRequest = messageClassObjectContainer.findBy(
                MessageType.Request, PayloadType.ConfigureAutopilot);
        //assertThat(configureAutopilotRequest, IsEqual.equalTo(ConfigureAutopilotRequest.class));

        Class<?> confirmDeliveryRequest = messageClassObjectContainer.findBy(
                MessageType.Request, PayloadType.ConfirmDelivery);
        //assertThat(confirmDeliveryRequest, IsEqual.equalTo(ConfirmDeliveryRequest.class));

        Class<?> goodbyeRequest = messageClassObjectContainer.findBy(
                MessageType.Request, PayloadType.Goodbye);
        //assertThat(goodbyeRequest, IsEqual.equalTo(GoodbyeRequest.class));

        Class<?> configureAutoPilotResponse = messageClassObjectContainer.findBy(
                MessageType.Response, PayloadType.ConfigureAutopilot);
        //assertThat(configureAutoPilotResponse, IsEqual.equalTo(ConfigureAutopilotResponse.class));

        Class<?> batteryStateMessageObj = messageClassObjectContainer.findBy(
                MessageType.State, PayloadType.BatteryState);
        //assertThat(batteryStateMessageObj, IsEqual.equalTo(BatteryStateMessage.class));

        Class<?> droneState = messageClassObjectContainer.findBy(
                MessageType.State, PayloadType.DroneState);
        //assertThat(droneState, IsEqual.equalTo(DroneStateMessage.class));

        Class<?> gpsState = messageClassObjectContainer.findBy(
                MessageType.State, PayloadType.GpsState);
        //assertThat(gpsState, IsEqual.equalTo(GpsStateMessage.class));
    }

    @Test(expected=CouldNotParseJsonException.class)
    public void CouldNotParseJsonException(){
        MessageClassObjectContainer messageClassObjectContainer = new MessageClassObjectContainer();

        Class<?> configureAutopilot = messageClassObjectContainer.findBy(
                MessageType.Request, PayloadType.BatteryState);

        //assertThat(configureAutopilotRequest, IsEqual.equalTo(ConfigureAutopilotRequest.class));

    }
}