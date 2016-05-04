package ch.helin.messages.dto.message;

import com.google.gson.annotations.SerializedName;

/**
 * PayloadType for each Message, is needed for GSON JSON parsing.
 */

public enum PayloadType {

    @SerializedName("GpsState")
    GpsState,

    @SerializedName("DroneState")
    DroneState,

    @SerializedName("BatteryState")
    BatteryState,

    @SerializedName("ConfigureAutopilot")
    ConfigureAutopilot,

    @SerializedName("ConfirmDelivery")
    ConfirmDelivery,

    @SerializedName("AssignMission")
    AssignMission,

    @SerializedName("ConfirmMission")
    ConfirmMission,

    @SerializedName("RejectMission")
    RejectMission,

    @SerializedName("ConfirmCargoLoaded")
    ConfirmCargoLoaded,

    @SerializedName("NotifyCargoDrop")
    NotifyCargoDrop,

    @SerializedName("DroneDto")
    DroneDto,

    @SerializedName("DroneInfo")
    DroneInfo
}


