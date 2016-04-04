package ch.helin.messages.converter;

import ch.helin.messages.dto.Message;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

/**
 * Created by styp on 03.04.16.
 */

public class MessageClassAdapter implements JsonDeserializer<Message> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MessageClassAdapter.class);

    private static final MessageClassObjectContainer classObjectContainer =
            new MessageClassObjectContainer();

    @Override
    public Message deserialize(JsonElement json,
                               Type typeOfT,
                               JsonDeserializationContext context) throws JsonParseException {

        JsonObject wholeJsonObject = json.getAsJsonObject();

        JsonElement messageTypePlain = wholeJsonObject.get("messageType");
        JsonElement eventTypePlain   = wholeJsonObject.get("eventType");


        MessageType messageType = context.deserialize(messageTypePlain, MessageType.class);
        EventType eventType = context.deserialize(eventTypePlain, EventType.class);

        Class<?> aClass = findClassBy(messageType, eventType);

        Message dematerializedMessage =
                context.deserialize(wholeJsonObject, aClass);
        return dematerializedMessage;
    }


    /**
     * @throws CouldNotParseJsonException if no class could be found
     */
    private Class<?> findClassBy(MessageType messageType, EventType eventType)
            throws CouldNotParseJsonException {

        AssertUtils.throwExceptionIfNull(messageType, "MessageType is mandatory.");
        AssertUtils.throwExceptionIfNull(eventType,   "EventType is mandatory.");

        Class<?> foundClass = classObjectContainer.findBy(messageType, eventType);

        if (foundClass == null) {
            LOGGER.warn("Given MessageType: {} and EventType: {}", messageType, eventType);
            throw new NullPointerException("No class found for given MessageType and EventType");
        }

        return foundClass;
    }

}