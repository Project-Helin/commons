package ch.helin.messages.dto.way;

import ch.helin.messages.dto.Action;

public class Waypoint {

    private Position position;
    private Action action;

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
