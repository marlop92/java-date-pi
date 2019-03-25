package pl.mlopatka;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        testInstant();
        testClock();
        testLocalDates();
        testZoned();
        testTimeDifference();
    }

    private static void testTimeDifference() {
        Duration duration = Duration.between(LocalDateTime.now(), LocalDateTime.now().minusHours(2));
        System.out.println("Duration difference: " + duration);
        Period period= Period.between(LocalDate.now(), LocalDate.now().minusWeeks(3));
        System.out.println("Period difference: " + period);
    }

    private static void testZoned() {
        ZonedDateTime zoned = ZonedDateTime.now();
        System.out.println(zoned);
    }

    private static void testLocalDates() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Local date: " + localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println("Local time: " + localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local date time: " + localDateTime);
    }

    private static void testClock() {
        Clock baseClock = Clock.systemDefaultZone();

        Clock clock = Clock.offset(baseClock, Duration.ofHours(72));
        System.out.println("Base clock date: " + baseClock.instant());
        System.out.println("Offset clock date: " + clock.instant());

        Instant now = Instant.now();
        Instant delay = Instant.now(clock);

        System.out.println("Measure offset with Instant: " + now.compareTo(delay));
    }

    private static void testInstant() {
        Instant first = Instant.now();
        System.out.println("First instant: " + first);

        Instant sec = Instant.now();
        System.out.println("Second instant: " + sec);

        System.out.println("Compare result " + sec.compareTo(first));
    }
}
