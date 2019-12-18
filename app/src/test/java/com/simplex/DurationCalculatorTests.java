package com.simplex;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

public class DurationCalculatorTests {

    @Test
    public void testSameDate() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 20, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 20, 0, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(0, duration);
    }

    @Test
    public void test30seconds() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 20, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 20, 0, 30).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(0, duration);
    }

    @Test
    public void testOneMinuteOffhours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 17, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 17, 1, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(0, duration);
    }

    @Test
    public void testOneHourOffHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 17, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 18, 0, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(0, duration);
    }

    @Test
    public void testOneMinuteOnHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 20, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 20, 1, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(1, duration);
    }

    @Test
    public void testOneHourOnHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 20, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 21, 0, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(60, duration);
    }

    @Test
    public void testUpperBorderOnHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 19, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 20, 1, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(1, duration);
    }

    @Test
    public void testLowerBorderOnHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 7, 59, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 17, 9, 0, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(1, duration);
    }

    @Test
    public void testOneDayOnHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 20, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 18, 20, 0, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(12 * 60, duration);
    }

    @Test
    public void testTwoDaysOnHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 17, 20, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2019, 11, 19, 20, 0, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(2 * 12 * 60, duration);
    }

    @Test
    public void testOneWeekDifferentMonthAndYearOnHours() {
        DurationCalculator durationCalculator = new DurationCalculator();
        Date arrivalTime = new GregorianCalendar(2019, 11, 26, 20, 0, 0).getTime();
        Date departureTime = new GregorianCalendar(2020, 0, 2, 20, 0, 0).getTime();
        Visit visit = new Visit(0,0, arrivalTime, departureTime);
        long duration = durationCalculator.calculateMinutesBetween8pmAnd8am(visit);
        Assert.assertEquals(7 * 12 * 60, duration);
    }

}
