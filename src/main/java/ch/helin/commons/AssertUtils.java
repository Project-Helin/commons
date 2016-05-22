package ch.helin.commons;

public class AssertUtils {
    private AssertUtils() {
        // this class has only static methods
    }

    public static Object throwExceptionIfNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Should not be null");
        }
        return object;
    }

    public static Object throwExceptionIfNull(Object object, String errorMessage) {
        if (object == null) {
            throw new IllegalArgumentException("Should not be null. Reason: " + errorMessage);
        }

        return object;
    }

    public static void throwExceptionIfNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                    "Given number should not be negative, but was " + number);
        }
    }
}
