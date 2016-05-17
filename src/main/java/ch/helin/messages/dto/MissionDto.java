package ch.helin.messages.dto;

import ch.helin.messages.dto.way.RouteDto;

public class MissionDto {

    private RouteDto route;

    private OrderProductDto orderProduct;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissionDto)) return false;

        MissionDto that = (MissionDto) o;

        if (route != null ? !route.equals(that.route) : that.route != null) return false;
        return orderProduct != null ? orderProduct.equals(that.orderProduct) : that.orderProduct == null;

    }

    @Override
    public int hashCode() {
        int result = route != null ? route.hashCode() : 0;
        result = 31 * result + (orderProduct != null ? orderProduct.hashCode() : 0);
        return result;
    }
}
