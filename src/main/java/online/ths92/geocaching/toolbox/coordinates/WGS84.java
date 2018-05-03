package online.ths92.geocaching.toolbox.coordinates;

import online.ths92.geocaching.Utils;

public class WGS84 {
    public static final int MINUTES_IN_DEGREE = 60;
    public static final int SECONDS_IN_MINUTE = 60;

    public static final int DECIMAL_DEGREES_DIGITS = 6;
    public static final int DECIMAL_MINUTES_DIGITS = 3;
    public static final int DECIMAL_SECONDS_DIGITS = 3;

    public static final char NORTH = 'N';
    public static final char SOUTH = 'S';
    public static final char WEST = 'W';
    public static final char EAST = 'E';

    private final double x;
    private final double y;


    public WGS84(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getXInDecimalDegrees () {
        double val = Utils.roundOff(x, DECIMAL_DEGREES_DIGITS);
        if (val >= 0) {
            return NORTH + " " + val;
        } else {
            return SOUTH + " " + Math.abs(val);
        }
    }

    public String getYInDecimalDegrees () {
        double val = Utils.roundOff(this.y, DECIMAL_DEGREES_DIGITS);
        if (val >= 0) {
            return EAST + " " + val;
        } else {
            return WEST + " " + Math.abs(val);
        }
    }

    public String getXInDegreesAndDecimalMinutes () {
        if (this.x >= 0) {
            return NORTH + " " + this.decimalDegreeToDegreesAndDecimalMinutes(this.x);
        } else {
            return SOUTH + " " + this.decimalDegreeToDegreesAndDecimalMinutes(this.x);
        }
    }

    public String getYInDegreesAndDecimalMinutes () {
        if (this.y >= 0) {
            return EAST + " " + this.decimalDegreeToDegreesAndDecimalMinutes(this.y);
        } else {
            return WEST + " " + this.decimalDegreeToDegreesAndDecimalMinutes(this.y);
        }
    }

    public String getXInDegreesMinutesAndSeconds () {
        if (this.x >= 0){
            return NORTH + " " + this.decimalDegreeToDegreesMinutesAndSeconds(this.x);
        } else {
            return SOUTH + " " + this.decimalDegreeToDegreesMinutesAndSeconds(this.x);
        }
    }

    public String getYInDegreesMinutesAndSeconds () {
        if (this.x >= 0){
            return EAST + " " + this.decimalDegreeToDegreesMinutesAndSeconds(this.x);
        } else {
            return WEST + " " + this.decimalDegreeToDegreesMinutesAndSeconds(this.x);
        }
    }

    private String decimalDegreeToDegreesAndDecimalMinutes(double val) {
        return Math.round(Math.floor(val)) + "° "
                + Utils.roundOff((val-Math.floor(val))*MINUTES_IN_DEGREE,DECIMAL_MINUTES_DIGITS);
    }

    private String decimalDegreeToDegreesMinutesAndSeconds (double val) {
        return Math.round(Math.floor(val)) + "° "
                + Math.round(Math.floor((val-Math.floor(val))*MINUTES_IN_DEGREE)) + "' "
                + Utils.roundOff((((val-Math.floor(val))*MINUTES_IN_DEGREE)-Math.floor((val-Math.floor(val))*MINUTES_IN_DEGREE))*SECONDS_IN_MINUTE,DECIMAL_SECONDS_DIGITS);
    }
}
