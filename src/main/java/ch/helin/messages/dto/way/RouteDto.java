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

}
