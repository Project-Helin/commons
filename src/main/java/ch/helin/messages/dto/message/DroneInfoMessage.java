package ch.helin.messages.dto.message;

import ch.helin.messages.dto.DroneInfoDto;

public class DroneInfoMessage extends Message{

    private DroneInfoDto droneInfo;

    public DroneInfoMessage() {
        super(PayloadType.DroneInfo);
    }


    public DroneInfoDto getDroneInfo() {
        return droneInfo;
    }

    public void setDroneInfo(DroneInfoDto droneInfo) {
        this.droneInfo = droneInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DroneInfoMessage)) return false;

        DroneInfoMessage that = (DroneInfoMessage) o;

        return droneInfo.equals(that.droneInfo);

    }

    @Override
    public int hashCode() {
        return droneInfo.hashCode();
    }
}
