package ch.helin.messages.dto.message;

import ch.helin.messages.dto.way.Position;

import java.util.UUID;
/**
 * DroneDTO to register a drone through HTTP channel.
 * Is needed for handshake to open AMQP communication channel.
 */

public class DroneDto {

    private UUID id;
    private String name;
    private UUID token;
    private Position lastKnownPosition;
    private int payload;
    private String organisationToken;
    private UUID projectID;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Position getLastKnownPosition() {
        return lastKnownPosition;
    }

    public void setLastKnownPosition(Position lastKnownPosition) {
        this.lastKnownPosition = lastKnownPosition;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public String getOrganisationToken() {
        return organisationToken;
    }

    public void setOrganisationToken(String organisationToken) {
        this.organisationToken = organisationToken;
    }

    public UUID getProjectID() {
        return projectID;
    }

    public void setProjectID(UUID projectID) {
        this.projectID = projectID;
    }

}
