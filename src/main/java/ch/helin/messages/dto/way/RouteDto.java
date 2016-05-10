package ch.helin.messages.dto.way;

import java.util.ArrayList;
import java.util.List;

public class RouteDto {

    private double distanceInMeters;

    private List<Waypoint> wayPoints = new ArrayList<>();

    public double getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(double distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public List<Waypoint> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(List<Waypoint> wayPoints) {
        this.wayPoints = wayPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteDto)) return false;

        RouteDto routeDto = (RouteDto) o;

        if (Double.compare(routeDto.distanceInMeters, distanceInMeters) != 0) return false;
        return wayPoints != null ? wayPoints.equals(routeDto.wayPoints) : routeDto.wayPoints == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(distanceInMeters);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (wayPoints != null ? wayPoints.hashCode() : 0);
        return result;
    }
}
