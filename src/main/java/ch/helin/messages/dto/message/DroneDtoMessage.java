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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DroneDtoMessage that = (DroneDtoMessage) o;

        return droneDto != null ? droneDto.equals(that.droneDto) : that.droneDto == null;

    }

    @Override
    public int hashCode() {
        return droneDto != null ? droneDto.hashCode() : 0;
    }

}
