package com.gridnine.testing;


import java.util.ArrayList;
import java.util.List;

public class ArrivalFilterBeforeDepartureDate implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            boolean isValidFlight = true;
            for (Segment segment : flight.getSegments()) {
                if (!segment.getArrivalDate().isAfter(segment.getDepartureDate())) {
                    isValidFlight = false;
                    break;
                }
            }
            if (isValidFlight) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

}
