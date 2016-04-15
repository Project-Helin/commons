package ch.helin.messages.converter;

import ch.helin.messages.dto.message.Message;

/**
 * @author Kirusanth Poopalasingam ( pkirusanth@gmail.com )
 */
public interface MessageConverter {

    /**
     * @return the parsed Message class - one if the sub-class of the Message
     * @throws CouldNotParseJsonException instead of null as return value
     *         this exception is thrown
     */
    Message parseStringToMessage(String incomingMessage) throws CouldNotParseJsonException;

    /**
     * @param message the message which needs to be mapped. Is not null
     * @return the appropriate representation of the message
     */
    String parseMessageToString(Message message);
}
