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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Waypoint)) return false;

        Waypoint waypoint = (Waypoint) o;

        if (id != null ? !id.equals(waypoint.id) : waypoint.id != null) return false;
        if (position != null ? !position.equals(waypoint.position) : waypoint.position != null) return false;
        return action == waypoint.action;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }
}
