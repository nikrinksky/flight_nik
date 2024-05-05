package com.gridnine.testing;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс фильтра, исключающий рейсы, вылет которых, происходит до текущего момента времени
 */
public class DepartureFilterUpToCurrentTime implements FlightFilter {
    /**
     * Фильтрует список рейсов, оставляя только те, вылет которых,
     * происходит после текущего времени.
     * @param flights Список рейсов, который нужно отфильтровать.
     * @return Список рейсов, у которых время вылета происходит после текущего времени.
     */
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
