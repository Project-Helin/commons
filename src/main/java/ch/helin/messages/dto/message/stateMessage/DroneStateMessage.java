package ch.helin.messages.dto.message.stateMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.state.DroneState;

public class DroneStateMessage extends Message {

    private DroneState droneState;

    public DroneStateMessage() {
        super(PayloadType.DroneState);
    }


    public DroneState getDroneState() {
        return droneState;
    }

    public void setDroneState(DroneState droneState) {
        this.droneState = droneState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DroneStateMessage that = (DroneStateMessage) o;

        return droneState != null ? droneState.equals(that.droneState) : that.droneState == null;

    }

    @Override
    public int hashCode() {
        return droneState != null ? droneState.hashCode() : 0;
    }
}
