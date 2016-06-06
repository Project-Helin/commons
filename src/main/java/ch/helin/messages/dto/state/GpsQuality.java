package ch.helin.messages.dto.state;

public enum GpsQuality {
    NO_FIX(0, "No fix points!"),
    _2D (2, "2D"),
    _3D (3, "3D");

    private final int legacyGpsStateInteger;
    private final String description;

    GpsQuality(int legacyGpsStateInteger, String description) {
        this.legacyGpsStateInteger = legacyGpsStateInteger;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static GpsQuality fromIndexOrReturnNoFix(int legacyGpsStateInteger){
        for (GpsQuality gpsQuality : values()) {
            if (gpsQuality.legacyGpsStateInteger == legacyGpsStateInteger){
                return gpsQuality;
            }
        }
        return GpsQuality.NO_FIX;
    }
}
