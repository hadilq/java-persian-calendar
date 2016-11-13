package ir.hadilq.util;

public class Calendars {

    public static int realYear(int year, boolean afterH) {
        if (afterH) {
            return mod(year + 38, 2820);
        } else {
            return mod(-year + 39, 2820);
        }
    }

    public static int mod(int i, int j) {
        int m = i % j;
        if (m < 0) {
            return m + j;
        } else {
            return m;
        }
    }

    /* To get integer part of a float */
    public static int getIntegerPart(double d) {
        if (d >= 0) return (int) Math.floor(d);
        else return (int) Math.floor(d) + 1;
    }
}
