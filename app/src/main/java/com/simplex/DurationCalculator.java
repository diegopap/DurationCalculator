package com.simplex;

import java.util.Calendar;

class DurationCalculator {

    private static final int OFF_MINUTES_IN_A_DAY = 12 * 60;

    long calculateMinutesBetween8pmAnd8am(Visit visit) {

        Calendar arrival = Calendar.getInstance();
        arrival.setTime(visit.getArrivalTime());

        Calendar departure = Calendar.getInstance();
        departure.setTime(visit.getDepartureTime());

        if (arrival.get(Calendar.HOUR_OF_DAY) > 7 && arrival.get(Calendar.HOUR_OF_DAY) < 20) {
            arrival.set(Calendar.HOUR_OF_DAY, 20);
            arrival.set(Calendar.MINUTE, 0);
            arrival.set(Calendar.SECOND, 0);
        }
        if (departure.get(Calendar.HOUR_OF_DAY) > 7 && departure.get(Calendar.HOUR_OF_DAY) < 20) {
            departure.set(Calendar.HOUR_OF_DAY, 8);
            departure.set(Calendar.MINUTE, 0);
            departure.set(Calendar.SECOND, 0);
        }
        long diff = departure.getTimeInMillis() - arrival.getTimeInMillis();
        long diffInMinutes = diff / 1000 / 60;
        long diffInDays = diffInMinutes / 60 / 24;
        return (diffInMinutes < 0) ? 0 : diffInMinutes - diffInDays * OFF_MINUTES_IN_A_DAY;
    }

}
