package ch.helin.messages.converter;

import ch.helin.messages.commons.AssertUtils;
import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.MessageType;
import ch.helin.messages.dto.PayloadType;
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

        JsonElement protocolTypePlain = wholeJsonObject.get("messageType");
        JsonElement payloadTypePlain  = wholeJsonObject.get("payloadType");


        MessageType messageType = context.deserialize(protocolTypePlain, MessageType.class);
        PayloadType payloadType = context.deserialize(payloadTypePlain, PayloadType.class);

        Class<?> aClass = findClassBy(messageType, payloadType);

        Message dematerializedMessage =
                context.deserialize(wholeJsonObject, aClass);
        return dematerializedMessage;
    }


    /**
     * @throws CouldNotParseJsonException if no class could be found
     */
    private Class<?> findClassBy(MessageType messageType, PayloadType payloadType)
            throws CouldNotParseJsonException {

        AssertUtils.throwExceptionIfNull(messageType, "ProtocolType is mandatory.");
        AssertUtils.throwExceptionIfNull(payloadType,   "PayloadType is mandatory.");

        Class<?> foundClass = classObjectContainer.findBy(messageType, payloadType);

        if (foundClass == null) {
            LOGGER.warn("Given MessageType: {} and EventType: {}", messageType, payloadType);
            throw new NullPointerException("No class found for given MessageType and EventType");
        }

        return foundClass;
    }

}