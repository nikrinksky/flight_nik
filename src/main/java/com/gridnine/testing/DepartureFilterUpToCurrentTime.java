package com.gridnine.testing;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureFilterUpToCurrentTime implements FlightFilter{
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        LocalDateTime currentTime = LocalDateTime.now();
        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight flight : flights) {
            boolean allSegmentsAfterCurrentTime = true;
            for (Segment segment : flight.getSegments()) {
                if (!segment.getDepartureDate().isAfter(currentTime)) {
                    allSegmentsAfterCurrentTime = false;
                    break;
                }
            }
            if (allSegmentsAfterCurrentTime) {
                filteredFlights.add(flight);
            }
        }

        return filteredFlights;
    }

}
