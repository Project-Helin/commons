package ch.helin.messages.dto.way;

import java.util.ArrayList;
import java.util.List;

public class Route {


    /**
     * TODO: rename this to distanceInMeter (?)
     */
    private double distance;

    private List<Waypoint> wayPoints = new ArrayList<>();

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Waypoint> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(List<Waypoint> wayPoints) {
        this.wayPoints = wayPoints;
    }

    // Mission here!

}
