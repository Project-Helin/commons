package ch.helin.commons;

public class ConnectionUtils {

    public static String getServerSideConsumerQueueName (String token) {
        return token + "-drone-to-server";
    }

    public static String getServerSideProducerQueueName (String token) {
        return token + "-server-to-drone";
    }

    public static String getDroneSideConsumerQueueName (String token) {
        return getServerSideProducerQueueName(token);
    }

    public static String getDroneSideProducerQueueName (String token) {
        return getServerSideConsumerQueueName(token);
    }
}
