package ch.helin.messages.dto;

import ch.helin.messages.dto.way.RouteDto;

import java.util.List;

public class MissionDto {

    private RouteDto routeDto;

    private List<OrderProductDto> orderProducts;

    public RouteDto getRouteDto() {
        return routeDto;
    }

    public void setRouteDto(RouteDto routeDto) {
        this.routeDto = routeDto;
    }

    public List<OrderProductDto> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductDto> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
