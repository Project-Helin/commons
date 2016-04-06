package ch.helin.messages.converter;

import ch.helin.messages.dto.HTTP.HTTPMessage;
import ch.helin.messages.dto.HTTP.HTTPRequestMessage;
import ch.helin.messages.dto.HTTP.HTTPResponseMessage;
import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.ProtocolType;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This class contains all the mapping from messageType to eventType to Class.
 *
 * @author Kirusanth Poopalasingam ( pkirusanth@gmail.com ) & Martin Stypinski ( mstypinski@gmail.com )
 */
public class MessageClassObjectContainer {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(MessageClassObjectContainer.class);

    private Map<ProtocolType, Map<ProtocolType, Class<?>>> messageTypeToProtocolType;

    public MessageClassObjectContainer() {
        messageTypeToProtocolType = new EnumMap<>(ProtocolType.class);

        addAllDerivedClassesToMap(HTTPMessage.class, ProtocolType.HTTP);
        addAllDerivedClassesToMap(HTTPRequestMessage.class, ProtocolType.HTTP_REQUEST);
        addAllDerivedClassesToMap(HTTPResponseMessage.class, ProtocolType.HTTP_RESPONSE);

    }

    private void addAllDerivedClassesToMap(Class<? extends Message> requestClass,
                                           ProtocolType protocolType) {


        List<Class<?>> foundClasses =
                findAllDerivedClassesOf(requestClass);

        Map<ProtocolType, Class<?>> payloadTypeToClassMap =
                buildPayloadTypeToClassMap(protocolType, foundClasses);

        messageTypeToProtocolType.put(protocolType, payloadTypeToClassMap);

        if (LOGGER.isTraceEnabled()) {
            logInternalClassMap();
        }

    }

    private Map<ProtocolType, Class<?>> buildPayloadTypeToClassMap(ProtocolType expectedPayloadType,
                                                                   List<Class<?>> foundClasses) {

        Map<ProtocolType, Class<?>> payloadTypeToClass = new EnumMap<>(ProtocolType.class);
        for (Class<?> eachClass : foundClasses) {
            Message anInstace = createAnInstance(eachClass);
            ProtocolType payloadType = anInstace.getProtocolType();

            payloadTypeToClass.put(payloadType, eachClass);
        }

        //Todo: Schönwetter case ausbaden :)

        return payloadTypeToClass;

    }

/*
    private Map<EventType, Class<?>> buildEventTypeToClassMap(MessageType expectedMessageType,
                                                              List<Class<?>> foundClasses) {

        Map<EventType, Class<?>> eventTypeToClass = new EnumMap<>(EventType.class);
        for (Class<?> eachClass : foundClasses) {

            Message anInstance  = createAnInstance(eachClass);
            EventType eventType = anInstance.getEventType();

            boolean isNotExpected = (anInstance.getMessageType() != expectedMessageType);
            if (isNotExpected) {
                LOGGER.warn("Check if class {} is derived correctly, because it's of type {}",
                        eachClass.getSimpleName(), expectedMessageType);
                throw new CouldNotParseJsonException("An unexpected class which is marked as " +
                        expectedMessageType + " but not derived correctly");
            }

            eventTypeToClass.put(eventType, eachClass);
        }

        st<Class<?>> foundClasses = new ArrayList<>();

        // c is a subclass of Widget or a descendant subclass.
        // This lambda expression is of type SubclassMatchProcessor.
        new FastClasspathScanner("ch.helin")
                .matchSubclassesOf(requestClass, foundClasses::add);

        foundClasses.stream().forEach(System.out::println);
        return eventTypeToClass;
    }
*/

    private Message createAnInstance(Class<?> eachClass) {
        try {

            Message message = (Message) eachClass.newInstance();
            return message;

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

        foundClasses.stream().forEach(System.out::println);

        return foundClasses;
    }

    /**
     * @param messageType
     * @param eventType
     * @return null if nothing found
     */

    public Class<?> findBy(ProtocolType messageType, PayloadType eventType) {
        Map<ProtocolType, Class<?>> eventTypeToClass =
                messageTypeToProtocolType.get(messageType);

        Class<?> foundClass = eventTypeToClass.get(eventType);
        return foundClass;
    }

    private void logInternalClassMap() {
        for (Map.Entry<ProtocolType, Map<ProtocolType, Class<?>>> each :
                messageTypeToProtocolType.entrySet()) {

            LOGGER.info("Message Type {} has: ", each.getKey());

            Map<ProtocolType, Class<?>> value = each.getValue();
            for (Map.Entry<ProtocolType, Class<?>> eventTypes : value.entrySet()) {
                LOGGER.info("EventType {} to {}", eventTypes.getKey(),
                        eventTypes.getValue());
            }
        }
    }

}
