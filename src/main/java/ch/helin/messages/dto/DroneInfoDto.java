package ch.helin.messages.dto;

import ch.helin.messages.dto.state.BatteryState;
import ch.helin.messages.dto.state.DroneState;
import ch.helin.messages.dto.state.GpsState;
import ch.helin.messages.dto.way.Position;

import java.util.Date;
import java.util.UUID;

public class DroneInfoDto {
    private UUID id;
    private BatteryState batteryState;
    private GpsState gpsState;
    private DroneState droneState;
    private Position phonePosition;
    private Date clientTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DroneInfoDto)) return false;

        DroneInfoDto that = (DroneInfoDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (batteryState != null ? !batteryState.equals(that.batteryState) : that.batteryState != null) return false;
        if (gpsState != null ? !gpsState.equals(that.gpsState) : that.gpsState != null) return false;
        if (droneState != null ? !droneState.equals(that.droneState) : that.droneState != null) return false;
        if (phonePosition != null ? !phonePosition.equals(that.phonePosition) : that.phonePosition != null)
            return false;
        return clientTime != null ? clientTime.equals(that.clientTime) : that.clientTime == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (batteryState != null ? batteryState.hashCode() : 0);
        result = 31 * result + (gpsState != null ? gpsState.hashCode() : 0);
        result = 31 * result + (droneState != null ? droneState.hashCode() : 0);
        result = 31 * result + (phonePosition != null ? phonePosition.hashCode() : 0);
        result = 31 * result + (clientTime != null ? clientTime.hashCode() : 0);
        return result;
    }
}
