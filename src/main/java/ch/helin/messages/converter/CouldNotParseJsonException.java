package ch.helin.messages.converter;

/**
 * Exception thrown to communicate the caller that the message could nto be parsed
 *
 * @author Kirusanth Poopalasingam ( pkirusanth@gmail.com ) & Martin Stypinski ( mstypinski@gmail.com )
 */
public class CouldNotParseJsonException extends RuntimeException {
    public CouldNotParseJsonException(String message) {
        super(message);
    }

    public CouldNotParseJsonException(String message, Exception causedException) {
        super(message, causedException);
    }
}
