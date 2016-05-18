package ch.helin.messages.converter;

import ch.helin.messages.commons.AssertUtils;
import ch.helin.messages.dto.message.DroneInfoMessage;
import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.message.missionMessage.*;
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
        AssertUtils.throwExceptionIfNull(payloadType);
        switch (payloadType) {
            case ConfirmCargoLoaded:
                return gson.fromJson(messageAsJson, ConfirmCargoLoaded.class);
            case NotifyCargoDrop:
                return gson.fromJson(messageAsJson, NotifyCargoDrop.class);
            case DroneInfo:
                return gson.fromJson(messageAsJson, DroneInfoMessage.class);
            case AssignMission:
                return gson.fromJson(messageAsJson, AssignMissionMessage.class);
            case FinalAssignMission:
                return gson.fromJson(messageAsJson, FinalAssignMissionMessage.class);
            case ConfirmMission:
                return gson.fromJson(messageAsJson, ConfirmMissionMessage.class);
            case FinishedMission:
                return gson.fromJson(messageAsJson, FinishedMissionMessage.class);

        }

        throw new RuntimeException("Following Type is not registered as Message-PayloadType: " + String.valueOf(payloadType));
    }

    @Override
    public String parseMessageToString(Message message) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.toJson(message);
    }
}
