package ch.helin.messages.dto;

import ch.helin.messages.dto.way.RouteDto;

import java.util.List;
import java.util.UUID;

public class MissionDto {

    private UUID id;
    private String state;
    private RouteDto route;
    private OrderProductDto orderProduct;
    private List<DroneInfoDto> droneInfos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RouteDto getRoute() {
        return route;
    }

    public void setRoute(RouteDto route) {
        this.route = route;
    }

    public OrderProductDto getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProductDto orderProduct) {
        this.orderProduct = orderProduct;
    }

    public List<DroneInfoDto> getDroneInfos() {
        return droneInfos;
    }

    public void setDroneInfos(List<DroneInfoDto> droneInfos) {
        this.droneInfos = droneInfos;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissionDto)) return false;

        MissionDto that = (MissionDto) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
