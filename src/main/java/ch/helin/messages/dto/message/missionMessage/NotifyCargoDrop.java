package ch.helin.messages.dto.message.missionMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.way.Waypoint;

/**
 * Created by martin on 14.04.16.
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
