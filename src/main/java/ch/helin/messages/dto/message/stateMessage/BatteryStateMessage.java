package ch.helin.messages.dto.message.stateMessage;

import ch.helin.messages.dto.message.Message;
import ch.helin.messages.dto.message.PayloadType;
import ch.helin.messages.dto.state.BatteryState;

public class BatteryStateMessage extends Message {

    private BatteryState batteryStage;

    public BatteryStateMessage() {
        super(PayloadType.BatteryState);
    }

    public BatteryState getBatteryStage() {
        return batteryStage;
    }

    public void setBatteryStage(BatteryState batteryStage) {
        this.batteryStage = batteryStage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatteryStateMessage that = (BatteryStateMessage) o;

        return batteryStage != null ? batteryStage.equals(that.batteryStage) : that.batteryStage == null;

    }

    @Override
    public int hashCode() {
        return batteryStage != null ? batteryStage.hashCode() : 0;
    }

}
