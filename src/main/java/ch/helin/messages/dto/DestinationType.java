package ch.helin.messages.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by styp on 06.04.16.
 */
public enum DestinationType {

    @SerializedName("PickUp")
    PickUp,

    @SerializedName("Delivery")
    Delivery,

}
