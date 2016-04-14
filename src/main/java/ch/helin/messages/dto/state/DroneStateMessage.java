package ch.helin.messages.dto.state;

import ch.helin.messages.dto.PayloadType;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 06.04.16.
 */
public class DroneStateMessage extends State {

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
