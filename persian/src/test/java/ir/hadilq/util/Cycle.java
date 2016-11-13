package ir.hadilq.util;

import junit.framework.Assert;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;

public class Cycle {
    private final Length length;

    private Cycle[] includeCycles;

    public Cycle() {
        this(Length.Cycle2820);
    }

    private Cycle(Length length) {
        this.length = length;
        Collection<Cycle> cycles = new ArrayDeque<>();
        switch (length) {
            case Cycle2820:
                addCycles(cycles, 21, Length.Cycle128);
                addCycles(cycles, 1, Length.Cycle132);
                includeCycles = cycles.toArray(new Cycle[cycles.size()]);
                break;
            case Cycle128:
                addCycles(cycles, 1, Length.Cycle29);
                addCycles(cycles, 3, Length.Cycle33);
                includeCycles = cycles.toArray(new Cycle[cycles.size()]);
                break;
            case Cycle132:
                addCycles(cycles, 1, Length.Cycle29);
                addCycles(cycles, 2, Length.Cycle33);
                addCycles(cycles, 1, Length.Cycle37);
                includeCycles = cycles.toArray(new Cycle[cycles.size()]);
                break;
            case Cycle29:
                addCycles(cycles, 1, Length.Cycle5);
                addCycles(cycles, 6, Length.Cycle4);
                includeCycles = cycles.toArray(new Cycle[cycles.size()]);
                break;
            case Cycle33:
                addCycles(cycles, 1, Length.Cycle5);
                addCycles(cycles, 7, Length.Cycle4);
                includeCycles = cycles.toArray(new Cycle[cycles.size()]);
                break;
            case Cycle37:
                addCycles(cycles, 1, Length.Cycle5);
                addCycles(cycles, 8, Length.Cycle4);
                includeCycles = cycles.toArray(new Cycle[cycles.size()]);
                break;
        }
    }

    private void addCycles(Collection<Cycle> cycles, int count, Length cycle) {
        for (int i = 0; i < count; i++) {
            cycles.add(new Cycle(cycle));
        }
    }

    public boolean isLeap(int realYearOffset) { // real year can be zero or negative
        if (includeCycles == null) {
            if (length != Length.Cycle4 && length != Length.Cycle5) {
                throw new IllegalArgumentException("Other cycles cannot have includeCycles == null: " + this);
            }

            return realYearOffset == interval();
        } else if (realYearOffset == 0) { // The last year of previous cycle always is a leap year
            return true;
        } else {
            int year = realYearOffset;
            for (Cycle cycle : includeCycles) {
                if (year > cycle.interval()) {
                    year -= cycle.interval();
                } else {
                    return cycle.isLeap(year);
                }
            }
        }
        throw new IllegalArgumentException("Shouldn't reach here: " + this);
    }

    public static boolean isLeap(Cycle cycle, int year, boolean afterH) {
        Assert.assertTrue("Year cannot be negative. Year: " + year, year > 0);
        return cycle.isLeap(Calendars.realYear(year, afterH));
    }

    private int interval() {
        return length.getInterval();
    }

    @Override
    public String toString() {
        return "Cycle{" +
                ", interval=" + length +
                ", includeCycles=" + Arrays.toString(includeCycles) +
                '}';
    }

    public enum Length {
        Cycle2820(2820),
        Cycle128(128),
        Cycle132(132),
        Cycle29(29),
        Cycle33(33),
        Cycle37(37),
        Cycle4(4),
        Cycle5(5);

        private int interval;

        Length(int interval) {
            this.interval = interval;
        }

        public int getInterval() {
            return interval;
        }
    }
}
