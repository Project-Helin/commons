package ch.helin.messages.services;

public interface MessageHandler <T> {
    void handle(T message);
}
