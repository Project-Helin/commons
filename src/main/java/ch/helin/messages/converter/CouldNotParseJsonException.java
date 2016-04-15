package ch.helin.messages.converter;

/**
 * Exception thrown to communicate the caller that the message could not be parsed

 */
public class CouldNotParseJsonException extends RuntimeException {

    public CouldNotParseJsonException(String message) {
        super(message);
    }

    public CouldNotParseJsonException(String message, Exception causedException) {
        super(message, causedException);
    }
}
