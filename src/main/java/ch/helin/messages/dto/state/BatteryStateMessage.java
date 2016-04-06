package ch.helin.messages.dto.state;

import ch.helin.messages.dto.PayloadType;

/**
 * @author Martin Stypinski ( mstypinski@gmail.com ) on 06.04.16.
 */
public class BatteryStateMessage extends State {

    private double voltage;
    private double remain;
    private double current;
    private double discharge;


    public BatteryStateMessage() {
        super(PayloadType.BatteryState);
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getDischarge() {
        return discharge;
    }

    public void setDischarge(double discharge) {
        this.discharge = discharge;
    }
}
