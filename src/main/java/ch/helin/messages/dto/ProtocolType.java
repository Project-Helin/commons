package ch.helin.messages.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */
public enum ProtocolType {
    @SerializedName("HTTP")
    HTTP,
    @SerializedName("RMQ")
    RMQ,

    //HTTP Types
    @SerializedName("HTTP_Request")
    HTTP_REQUEST,

    @SerializedName("HTTP_Response")
    HTTP_RESPONSE,

    //RMQ Types
    @SerializedName("RMQ_Request")
    RMQ_REQUEST,

    @SerializedName("RMQ_Response")
    RMQ_RESPONSE,

    @SerializedName("RMQ_Broadcast")
    RMQ_BROADCAST,


}
