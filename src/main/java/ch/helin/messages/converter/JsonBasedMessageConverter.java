package ch.helin.messages.converter;

import ch.helin.messages.commons.AssertUtils;
import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.message.missionMessage.*;
import ch.helin.messages.dto.message.stateMessage.BatteryStateMessage;
import ch.helin.messages.dto.message.stateMessage.DroneStateMessage;
import ch.helin.messages.dto.message.stateMessage.GpsStateMessage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json Specific MessageConverter
 */
public class JsonBasedMessageConverter implements MessageConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonBasedMessageConverter.class);

    @Override
    public Message parseStringToMessage(String messageAsJson) throws CouldNotParseJsonException {
        try {

            return parseMessageWithoutCare(messageAsJson);

        } catch (RuntimeException catchedException) {

            LOGGER.warn("Failed to parse following json message:\n {}", messageAsJson);
            throw new CouldNotParseJsonException("Json message parsing failed", catchedException);

        }
    }

    private Message parseMessageWithoutCare(String messageAsJson) {
        Gson gson = new GsonBuilder().create();

        Message parsedMessage = gson.fromJson(messageAsJson, Message.class);
        AssertUtils.throwExceptionIfNull(parsedMessage);

        PayloadType payloadType = parsedMessage.getPayloadType();
        switch (payloadType) {
            case DroneState:
                return gson.fromJson(messageAsJson, DroneStateMessage.class);
            case GpsState:
                return gson.fromJson(messageAsJson, GpsStateMessage.class);
            case BatteryState:
                return gson.fromJson(messageAsJson, BatteryStateMessage.class);

            case ConfirmCargoLoaded:
                return gson.fromJson(messageAsJson, ConfirmCargoLoaded.class);
            case NotifyCargoDrop:
                return gson.fromJson(messageAsJson, NotifyCargoDrop.class);

        }

        throw new RuntimeException(String.valueOf(payloadType));
    }

    @Override
    public String parseMessageToString(Message message) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.toJson(message);
    }
}
