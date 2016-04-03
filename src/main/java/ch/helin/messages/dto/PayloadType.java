package ch.helin.messages.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */

public enum PayloadType {
    @SerializedName("GpsState")
    GpsState,
    @SerializedName("response")
    Response,
    @SerializedName("broadcast")
    Broadcast;
}


