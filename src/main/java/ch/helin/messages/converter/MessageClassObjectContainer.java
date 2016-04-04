package ch.helin.messages.converter;

import ch.helin.messages.dto.HTTP.HTTPMessage;
import ch.helin.messages.dto.HTTP.HTTPRequestMessage;
import ch.helin.messages.dto.HTTP.HTTPResponseMessage;
import ch.helin.messages.dto.Message;
import ch.helin.messages.dto.PayloadType;
import ch.helin.messages.dto.ProtocolType;
import ch.hsr.blox.commons.message.EventType;
import ch.hsr.blox.commons.message.Message;
import ch.hsr.blox.commons.message.MessageType;
import ch.hsr.blox.commons.message.broadcast.Broadcast;
import ch.hsr.blox.commons.message.request.Request;
import ch.hsr.blox.commons.message.response.Response;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.util.*;

/**
 * This class contains all the mapping from messageType to eventType to Class.
 *
 * @author Kirusanth Poopalasingam ( pkirusanth@gmail.com ) & Martin Stypinski ( mstypinski@gmail.com )
 */
public class MessageClassObjectContainer {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(MessageClassObjectContainer.class);

    private Map<ProtocolType, Map<PayloadType, Class<?>>> messageTypeToProtocolType;

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

        Map<EventType, Class<?>> eventTypeToClassMap =
                buildEventTypeToClassMap(messageType, foundClasses);

        messageTypeToEventTypeToClassMap.put(messageType, eventTypeToClassMap);

        if (LOGGER.isTraceEnabled()) {
            logInternalClassMap();
        }
    }

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

        return eventTypeToClass;
    }

    private Message createAnInstance(Class<?> eachClass) {
        try {

            Message message = (Message) eachClass.newInstance();
            return message;

        } catch (Exception e) {
            throw new CouldNotParseJsonException(
                    "Failed to create instance for: " + eachClass.getSimpleName(), e);
        }
    }

    private List<Class<?>> findAllDerivedClassesOf(Class<?> requestClass){
        Reflections reflections = new Reflections("com.helin.messages.dto");
        Set<Class<? extends Message>> classes = reflections.getSubTypesOf(requestClass.class);

        Set<BeanDefinition> beanDefinitions = findAllBeanDefinitions(requestClass);

        List<Class<?>> classes = new ArrayList<>(beanDefinitions.size());
        for (BeanDefinition eachDefinition : beanDefinitions) {
            String beanClassName = eachDefinition.getBeanClassName();

            try {
                Class<?> aClass = Class.forName(beanClassName);

                boolean isNotBaseClassItself = (!aClass.equals(requestClass));
                if (isNotBaseClassItself) {
                    classes.add(aClass);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Could not find class for " + beanClassName);
            }
        }
        return classes;
    }

    /**
     * We use spring to get all derived classes.
     * @param requestClass list of all classes wrapped around Springs
     *                     BeanDefinition
     */
    private Set<BeanDefinition> findAllBeanDefinitions(Class<?> requestClass) {
        boolean useDefaultFilter = false;
        ClassPathScanningCandidateComponentProvider classPathScanner =
                new ClassPathScanningCandidateComponentProvider(useDefaultFilter);

        classPathScanner.addIncludeFilter(new AssignableTypeFilter(Message.class));

        Set<BeanDefinition> candidateComponents =
                classPathScanner.findCandidateComponents(requestClass.getPackage().getName());
        return candidateComponents;
    }

    /**
     * @return null if nothing found
     * @param messageType
     * @param eventType
     */
    public Class<?> findBy(ProtocolType messageType, PayloadType eventType) {
        Map<EventType, Class<?>> eventTypeToClass =
                messageTypeToEventTypeToClassMap.get(messageType);

        Class<?> foundClass = eventTypeToClass.get(eventType);
        return foundClass;
    }

    private void logInternalClassMap() {
        for (Map.Entry<MessageType, Map<EventType, Class<?>>> each :
                messageTypeToEventTypeToClassMap.entrySet()) {

            LOGGER.info("Message Type {} has: ", each.getKey());

            Map<EventType, Class<?>> value = each.getValue();
            for (Map.Entry<EventType, Class<?>> eventTypes : value.entrySet()) {
                LOGGER.info("EventType {} to {}", eventTypes.getKey(),
                        eventTypes.getValue());
            }
        }
    }
}
