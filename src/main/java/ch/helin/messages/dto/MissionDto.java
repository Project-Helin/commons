package ch.helin.messages.dto;

import ch.helin.messages.dto.way.RouteDto;

public class MissionDto {

    private RouteDto routeDto;

    private OrderProductDto orderProduct;

    public RouteDto getRouteDto() {
        return routeDto;
    }

    public void setRouteDto(RouteDto routeDto) {
        this.routeDto = routeDto;
    }

    public OrderProductDto getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProductDto orderProduct) {
        this.orderProduct = orderProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissionDto)) return false;

        MissionDto that = (MissionDto) o;

        if (routeDto != null ? !routeDto.equals(that.routeDto) : that.routeDto != null) return false;
        return orderProduct != null ? orderProduct.equals(that.orderProduct) : that.orderProduct == null;

    }

    @Override
    public int hashCode() {
        int result = routeDto != null ? routeDto.hashCode() : 0;
        result = 31 * result + (orderProduct != null ? orderProduct.hashCode() : 0);
        return result;
    }
}
