package ch.helin.messages.dto;

import com.google.gson.annotations.SerializedName;
import com.sun.xml.internal.ws.developer.Serialization;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */

public enum PayloadType {
    @SerializedName("response")
    Response,
    @SerializedName("broadcast")
    Broadcast,


    @SerializedName("GpsState")
    GpsState,

    @SerializedName("DroneState")
    DroneState,

    @SerializedName("BatteryState")
    BatteryState,

    @SerializedName("ConfigureAutopilotReq")
    ConfigureAutopilotReq,

    @SerializedName("ConfigureAutopilotRsp")
    ConfigureAutopilotRsp, ConfirmDeliveryReq, Goodbye;


}


