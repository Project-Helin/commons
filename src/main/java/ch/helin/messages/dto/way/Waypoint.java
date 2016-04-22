package ch.helin.messages.dto.way;

import ch.helin.messages.dto.Action;

import java.util.UUID;

public class Waypoint {

    private UUID id;
    private Position position;
    private Action action;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
