package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrivalFilterBeforeDepartureDateTest {
    //Этот тест создает объект ArrivalFilterBeforeDepartureDate,
    // создает несколько сегментов и рейсов,
    // а затем проверяет, что метод filterFlights корректно фильтрует рейсы
    // в соответствии с условиями метода.
    @Test
    public void testFilterFlights() {
        ArrivalFilterBeforeDepartureDate filter = new ArrivalFilterBeforeDepartureDate();

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime futureTime = currentTime.plusHours(1);
        LocalDateTime pastTime = currentTime.minusHours(1);

        Segment segment1 = new Segment( currentTime, futureTime);
        Segment segment2 = new Segment(futureTime, futureTime.plusHours(2));
        Segment segment3 = new Segment(futureTime.plusHours(3), pastTime);

        List<Segment> segments1 = new ArrayList<>();
        segments1.add(segment1);
        segments1.add(segment2);

        List<Segment> segments2 = new ArrayList<>();
        segments2.add(segment2);
        segments2.add(segment3);

        Flight flight1 = new Flight( segments1);
        Flight flight2 = new Flight(segments2);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        List<Flight> filteredFlights = filter.filterFlights(flights);

        assertEquals(1, filteredFlights.size());
        assertEquals(flight1, filteredFlights.get(0));
    }
}