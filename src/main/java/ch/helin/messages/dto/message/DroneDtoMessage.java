package ch.helin.messages.dto.message;

public class DroneDtoMessage extends Message {
    private DroneDto droneDto;

    public DroneDtoMessage() {
        super(PayloadType.DroneDto);
    }


    public DroneDto getDroneDto() {
        return droneDto;
    }

    public void setDroneDto(DroneDto droneDto) {
        this.droneDto = droneDto;
    }
}
