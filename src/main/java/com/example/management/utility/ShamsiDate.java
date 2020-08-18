package com.example.management.utility;

public class ShamsiDate {
    private final long value;
    private long day;
    private long month;


    public ShamsiDate(String date) {


        String[] split = date.split("/");
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        if (month <= 7) {
            value = (month - 1) * 31 + day;

        } else {

            value = (month - 7) * 30 + day + 186;
        }
    }

    public ShamsiDate(long value) {
        this.value = value;


        if (value <= 186) {
            month = value / 31 + 1;
            day = value % 31;
            if (day == 0) {
                day = 31;
                month = month - 1;
            }
        } else {
            value = value - 186;
            month = value / 30 + 7;
            day = value % 30;
            if (day == 0) {
                day = 30;
                month = month - 1;
            }
        }


    }

    @Override
    public String toString() {
        return "99" + "/" + month + "/" + day;
    }

    public long getValue() {

        return value;
    }


}

/*    public boolean checkForOverlap( ShamsiDate start2, ShamsiDate end2) {
        return (va >= changeDate(start2) || changeDate(end1) >= changeDate(start2)) && (changeDate(start1) <= changeDate(start2) || changeDate(start1) <= changeDate(end2));

    }

    public int deducted(String start, String end) {
        return changeDate(end) - changeDate(start);
    }

}*/
