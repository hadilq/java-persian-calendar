package ir.hadilq.test;

import ir.hadilq.PersianCalendar;
import ir.hadilq.util.Cycle;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Calendar;

public class PersianCalendarUnitTest {

    private int wrongTry = 0;

    @Test
    public void isLeapYearsCorrect() throws Exception {
        Cycle bigCycle = new Cycle();

        for (int i = 1; i < 3000; i++) {
            checkYear(bigCycle, i, true);
        }

        for (int i = 1; i < 3000; i++) {
            checkYear(bigCycle, i, false);
        }
    }

    private void checkYear(Cycle bigCycle, int year, boolean afterH) throws Exception {
        boolean realLeap = Cycle.isLeap(bigCycle, year, afterH);
        boolean leap = PersianCalendar.isLeapYear(year, afterH);
        if (realLeap ^ leap) {
            throw new Exception("This year is wrong: " + year + ", afterH: " + afterH + ", realLeap: " + realLeap +
                    ", leap:" + leap);
        }
    }

    @Test
    public void isLeap() throws Exception {
        Cycle bigCycle = new Cycle();
        // In this year the real year will become zero
        if (!Cycle.isLeap(bigCycle, 2782, true)) {
            throw new Exception();
        }
    }


    @Test
    public void isFixedDateCorrect() throws Exception {
        Cycle bigCycle = new Cycle();
        // In this year the real year will become zero
        System.out.println("Fix date: " + PersianCalendar.getFixedDateFar1(2781, true));
//        if () {
//            throw new Exception();
//        }
    }


    @Test
    public void printLeaps() throws Exception {
        Cycle bigCycle = new Cycle();
        for (int i = 1; i < 20; i++) {
            System.out.println("year: " + i + ", is leap: " + Cycle.isLeap(bigCycle, i, true));
        }
    }

    @Test
    public void isFixedDateFormFar1Correct() throws Exception {
        int days = 1; // The first day of calendar, FARVARDIN 1, 1

        Cycle bigCycle = new Cycle();

        for (int i = 1; i < 3000; i++) {
            checkFixedDateFromFar1(i, true, days);
            if (Cycle.isLeap(bigCycle, i, true)) {
                days += 366;
            } else {
                days += 365;
            }
        }

        days = 1;
        for (int i = 1; i < 3000; i++) {
            if (Cycle.isLeap(bigCycle, i, false)) {
                days -= 366;
            } else {
                days -= 365;
            }
            checkFixedDateFromFar1(i, false, days);
        }
    }

    private void checkFixedDateFromFar1(int year, boolean afterH, int days) throws Exception {
        int fixedDateFar1 = PersianCalendar.getFixedDateFar1(year, afterH);
        if (days != fixedDateFar1) {
            System.out.println("Fixed date is not calculated correct! Year:" + year +
                    ", days: " + days + ", fixedDateFar1: " + fixedDateFar1 +
                    " isLeap: " + PersianCalendar.isLeapYear(year, afterH) +
                    " next year isLeap: " + PersianCalendar.isLeapYear(year + 1, afterH) +
                    (year > 1 ? " previous year isLeap: " + PersianCalendar.isLeapYear(year - 1, afterH) : ""));
            wrongTry++;
            if (wrongTry > 100) {
                throw new Exception();
            }
        }
    }

    @Test
    public void checkPersianCalendarIsRunning() throws Exception {
        PersianCalendar calendar = new PersianCalendar();
        System.out.println("year: " + calendar.get(Calendar.YEAR) + ", month: " + calendar.get(Calendar.MONTH) +
                ", day of month: " + calendar.get(Calendar.DAY_OF_MONTH) + ", hour: " + calendar.get(Calendar.HOUR_OF_DAY) +
                ", minutes: " + calendar.get(Calendar.MINUTE) + ", seconds: " + calendar.get(Calendar.SECOND) +
                ", millis: " + calendar.get(Calendar.MILLISECOND));
    }

    @Test
    public void comparePersianCalendarTimeWithSample() throws Exception {
        PersianCalendar calendar = new PersianCalendar();
        calendar.setTimeInMillis(1479022012901L);
        Assert.assertTrue("Year: " + calendar.get(Calendar.YEAR), calendar.get(Calendar.YEAR) == 1395);
        Assert.assertTrue("Month: " + calendar.get(Calendar.MONTH), calendar.get(Calendar.MONTH) == 7);
        Assert.assertTrue("Day of month: " + calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.DAY_OF_MONTH) == 23);
        Assert.assertTrue("Hour: " + calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.HOUR_OF_DAY) == 10);
        Assert.assertTrue("Hour: " + calendar.get(Calendar.MINUTE), calendar.get(Calendar.MINUTE) == 56);
        Assert.assertTrue("Hour: " + calendar.get(Calendar.SECOND), calendar.get(Calendar.SECOND) == 52);
        Assert.assertTrue("Millis: " + calendar.get(Calendar.MILLISECOND), calendar.get(Calendar.MILLISECOND) == 901);
    }

    @Test
    public void comparePersianCalendarFieldsWithSample() throws Exception {
        PersianCalendar calendar = new PersianCalendar(1395, 7, 23, 10, 56, 52);
        long expected = 1479022012000L;
        long timeInMillis = calendar.getTimeInMillis();
        Assert.assertTrue("Millis: " + timeInMillis + ", It should be: " + expected +
                        ", diff is: " + (timeInMillis - expected),
                timeInMillis == expected);
    }
}
