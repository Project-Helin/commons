package ch.helin.messages.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 03.04.16.
 */
public enum MessageType {
    @SerializedName("request")
    Request,
    @SerializedName("response")
    Response,
    @SerializedName("state")
    State
    ;

}
