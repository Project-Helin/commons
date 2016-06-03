package ch.helin.messages.dto.message;

public class DroneActiveStateMessage extends Message {

    private DroneActiveState droneActiveState;

    public DroneActiveStateMessage() {
        super(PayloadType.DroneActiveState);
    }

    public DroneActiveState getDroneActiveState() {
        return droneActiveState;
    }

    public void setDroneActiveState(DroneActiveState droneActiveState) {
        this.droneActiveState = droneActiveState;
    }

    @Override
    public String toString() {
        return "DroneActiveStateMessage{" +
                "droneActiveState=" + droneActiveState +
                '}';
    }

}
