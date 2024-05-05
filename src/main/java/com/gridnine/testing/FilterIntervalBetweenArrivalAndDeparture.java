package com.gridnine.testing;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterIntervalBetweenArrivalAndDeparture implements FlightFilter {

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredSegments = new ArrayList<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrivalDateTime = segments.get(i).getArrivalDate();
                LocalDateTime departureDateTime = segments.get(i + 1).getDepartureDate();

                if (arrivalDateTime.plusHours(2).isBefore(departureDateTime)) {
                    filteredSegments.add(flights.get(i));
                    filteredSegments.add(flights.get(i + 1));
                }
            }
        }

        return filteredSegments;
    }

}
