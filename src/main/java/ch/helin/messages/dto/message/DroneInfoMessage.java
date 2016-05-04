package ch.helin.messages.dto.message;

import ch.helin.messages.dto.state.BatteryState;
import ch.helin.messages.dto.state.DroneState;
import ch.helin.messages.dto.state.GpsState;
import ch.helin.messages.dto.way.Position;
import java.util.Date;


public class DroneInfoMessage extends Message{

    private BatteryState batteryState;
    private GpsState gpsState;
    private DroneState droneState;
    private Position phonePosition;
    private Date clientTime;

    public DroneInfoMessage() {
        super(PayloadType.DroneInfo);
    }

    public BatteryState getBatteryState() {
        return batteryState;
    }

    public void setBatteryState(BatteryState batteryState) {
        this.batteryState = batteryState;
    }

    public GpsState getGpsState() {
        return gpsState;
    }

    public void setGpsState(GpsState gpsState) {
        this.gpsState = gpsState;
    }

    public DroneState getDroneState() {
        return droneState;
    }

    public void setDroneState(DroneState droneState) {
        this.droneState = droneState;
    }

    public Position getPhonePosition() {
        return phonePosition;
    }

    public void setPhonePosition(Position phonePosition) {
        this.phonePosition = phonePosition;
    }

    public Date getClientTime() {
        return clientTime;
    }

    public void setClientTime(Date clientTime) {
        this.clientTime = clientTime;
    }
}
