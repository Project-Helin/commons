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

    private boolean active;

    private RabbitMqInformation rabbitMqInformation;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RabbitMqInformation getRabbitMqInformation() {
        return rabbitMqInformation;
    }

    public void setRabbitMqInformation(RabbitMqInformation rabbitMqInformation) {
        this.rabbitMqInformation = rabbitMqInformation;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DroneDto droneDto = (DroneDto) o;

        if (payload != droneDto.payload) return false;
        if (active != droneDto.active) return false;
        if (id != null ? !id.equals(droneDto.id) : droneDto.id != null) return false;
        if (name != null ? !name.equals(droneDto.name) : droneDto.name != null) return false;
        if (token != null ? !token.equals(droneDto.token) : droneDto.token != null) return false;
        if (lastKnownPosition != null ? !lastKnownPosition.equals(droneDto.lastKnownPosition) : droneDto.lastKnownPosition != null)
            return false;
        if (organisationToken != null ? !organisationToken.equals(droneDto.organisationToken) : droneDto.organisationToken != null)
            return false;
        if (projectID != null ? !projectID.equals(droneDto.projectID) : droneDto.projectID != null) return false;
        return rabbitMqInformation != null ? rabbitMqInformation.equals(droneDto.rabbitMqInformation) : droneDto.rabbitMqInformation == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (lastKnownPosition != null ? lastKnownPosition.hashCode() : 0);
        result = 31 * result + payload;
        result = 31 * result + (organisationToken != null ? organisationToken.hashCode() : 0);
        result = 31 * result + (projectID != null ? projectID.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (rabbitMqInformation != null ? rabbitMqInformation.hashCode() : 0);
        return result;
    }
}
