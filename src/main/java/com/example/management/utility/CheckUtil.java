package com.example.management.utility;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class CheckUtil {
    static LocalDate START = LocalDate.of(2020, Month.MARCH, 20);

    public static String getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        long current = ChronoUnit.DAYS.between(START, localDate) + 1;
        return new ShamsiDate(current).toString();

    }

    public boolean checkForOverlap(ShamsiDate start1, ShamsiDate end1, ShamsiDate start2, ShamsiDate end2) {
        return (start1.getValue() >= start2.getValue() || end1.getValue() >= start2.getValue()) && (start1.getValue() <= start2.getValue() || start1.getValue() <= end2.getValue());

    }

    public long deducted(ShamsiDate start, ShamsiDate end) {
        return end.getValue() - start.getValue() + 1;
    }

    public boolean DateIsAccurate(ShamsiDate start, ShamsiDate end) {
        return end.getValue() > start.getValue();
    }
}
