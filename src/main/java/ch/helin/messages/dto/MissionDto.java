package ch.helin.messages.dto;

import ch.helin.messages.dto.way.RouteDto;

import java.util.List;

public class MissionDto {

    private String state;

    private RouteDto route;

    private OrderProductDto orderProduct;

    private List<DroneInfoDto> droneInfos;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissionDto)) return false;

        MissionDto that = (MissionDto) o;

        if (route != null ? !route.equals(that.route) : that.route != null) return false;
        if (orderProduct != null ? !orderProduct.equals(that.orderProduct) : that.orderProduct != null) return false;
        return droneInfos != null ? droneInfos.equals(that.droneInfos) : that.droneInfos == null;

    }

    @Override
    public int hashCode() {
        int result = route != null ? route.hashCode() : 0;
        result = 31 * result + (orderProduct != null ? orderProduct.hashCode() : 0);
        result = 31 * result + (droneInfos != null ? droneInfos.hashCode() : 0);
        return result;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
