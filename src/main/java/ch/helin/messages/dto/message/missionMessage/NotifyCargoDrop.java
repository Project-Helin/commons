package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.way.Waypoint;

/**
 * Message to notify the server that the cargo is ready to be droped.
 * Sent as soon as drone reaches its last RoutePoint with Action Drop.
 */
public class NotifyCargoDrop extends Message{

    private Waypoint dropPoint;

    public NotifyCargoDrop() {
        super(PayloadType.NotifyCargoDrop);
    }

    public Waypoint getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(Waypoint dropPoint) {
        this.dropPoint = dropPoint;
    }
}
