package ch.helin.messages.converter;

import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.MessageType;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.request.ConfigureAutopilotRequest;
import ch.helin.messages.dto.request.Request;
import ch.helin.messages.dto.response.Response;
import ch.helin.messages.dto.state.State;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * This class contains all the mapping from messageType to eventType to Class.
 *
 * @author Kirusanth Poopalasingam ( pkirusanth@gmail.com ) & Martin Stypinski ( mstypinski@gmail.com )
 */
public class MessageClassObjectContainer {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(MessageClassObjectContainer.class);

    private Map<MessageType, Map<PayloadType, Class<?>>> messageTypeToProtocolType;

    public MessageClassObjectContainer() {
        messageTypeToProtocolType = new EnumMap<>(MessageType.class);

        addAllDerivedClassesToMap(Request.class, MessageType.Request);
        addAllDerivedClassesToMap(Response.class, MessageType.Response);
        addAllDerivedClassesToMap(State.class, MessageType.State);
    }

    private void addAllDerivedClassesToMap(Class<? extends Message> requestClass,
                                           MessageType messageType) {


        List<Class<?>> foundClasses =
                findAllDerivedClassesOf(requestClass);

        Map<PayloadType, Class<?>> payloadTypeToClassMap =
                buildPayloadTypeToClassMap(messageType, foundClasses);

        messageTypeToProtocolType.put(messageType, payloadTypeToClassMap);

        if (LOGGER.isTraceEnabled()) {
            logInternalClassMap();
        }

    }

    private Map<PayloadType, Class<?>> buildPayloadTypeToClassMap(MessageType expectedMessageType,
                                                              List<Class<?>> foundClasses) {

        Map<PayloadType, Class<?>> payloadTypeToClass = new EnumMap<>(PayloadType.class);
        for (Class<?> eachClass : foundClasses) {

            Message anInstance  = createAnInstance(eachClass);
            PayloadType PayloadType = anInstance.getPayloadType();

            boolean isNotExpected = (anInstance.getMessageType() != expectedMessageType);
            if (isNotExpected) {
                LOGGER.warn("Check if class {} is derived correctly, because it's of type {}",
                        eachClass.getSimpleName(), expectedMessageType);
                throw new CouldNotParseJsonException("An unexpected class which is marked as " +
                        expectedMessageType + " but not derived correctly");
            }

            payloadTypeToClass.put(PayloadType, eachClass);
        }

        return payloadTypeToClass;
    }

    private Message createAnInstance(Class<?> eachClass) {
        try {

            Message message = (Message) eachClass.newInstance();
            return message;

        } catch (InstantiationException e) {
            throw new CouldNotParseJsonException(
                    "Failed to instantiate " + eachClass.getSimpleName() + ". This may be due to a missing empty-parameter constructor. " +
                    "Please check if " + eachClass.getSimpleName() + " has an empty-constructor!" , e);
        } catch (Exception e) {
            throw new CouldNotParseJsonException(
                    "Failed to create instance for: " + eachClass.getSimpleName(), e);
        }
    }

    private List<Class<?>> findAllDerivedClassesOf(Class<?> requestClass) {

        List<Class<?>> foundClasses = new ArrayList<>();

        /**
         * Scan  classpath to get all sub-classes of given class
         */
        new FastClasspathScanner("ch.helin")
                .matchSubclassesOf(requestClass, foundClasses::add)
                // .verbose()
                .scan();

        foundClasses.stream().forEach((i) ->{
            LOGGER.info("Found {} which is derived from {}" , i.getSimpleName(), requestClass.getSimpleName());
        });

        return foundClasses;
    }

    /**
     * @param messageType
     * @param payloadType
     * @return null if nothing found
     */

    public Class<?> findBy(MessageType messageType, PayloadType payloadType){
        Map<PayloadType, Class<?>> payloadTypeToClass =
                messageTypeToProtocolType.get(messageType);

        Class<?> foundClass = payloadTypeToClass.get(payloadType);

        if(foundClass == null){
            throw new CouldNotParseJsonException("Could not find matching object to given messageType=" +
                    messageType + "& payloadTyp=" + payloadType + "!");
        }

        return foundClass;
    }

    private void logInternalClassMap() {
        for (Map.Entry<MessageType, Map<PayloadType, Class<?>>> each :
                messageTypeToProtocolType.entrySet()) {

            LOGGER.info("Message Type {} has: ", each.getKey());

            Map<PayloadType, Class<?>> value = each.getValue();
            for (Map.Entry<PayloadType, Class<?>> eventTypes : value.entrySet()) {
                LOGGER.info("EventType {} to {}", eventTypes.getKey(),
                        eventTypes.getValue());
            }
        }
    }
}
