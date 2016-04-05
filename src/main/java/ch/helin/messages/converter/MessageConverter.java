package ch.helin.messages.converter;

import ch.helin.messages.commons.AssertUtils;
import ch.helin.messages.dto.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
