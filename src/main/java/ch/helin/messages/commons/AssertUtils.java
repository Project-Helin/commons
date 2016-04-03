package ch.helin.messages.commons;

/**
 * @author Kirusanth Poopalasingam ( pkirusanth@gmail.com ) & Martin Stypinski ( mstypinski@gmail.com )
 */
public class AssertUtils {
    private AssertUtils() {
        // this class has only static methods
    }

    public static void throwExceptionIfNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Should not be null");
        }
    }

    public static void throwExceptionIfNull(Object object, String errorMessage) {
        if (object == null) {
            throw new IllegalArgumentException("Should not be null. Reason: " + errorMessage);
        }
    }

    public static void throwExceptionIfNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                    "Given number should not be negative, but was " + number);
        }
    }
}
