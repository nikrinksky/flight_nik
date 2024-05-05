package com.gridnine.testing;


import java.util.ArrayList;
import java.util.List;

/**
 * Класс фильтра, исключающий рейсы, прибытие которых, перед датой вылета следующего рейса
 */
public class ArrivalFilterBeforeDepartureDate implements FlightFilter {
    /**
     * Фильтрует список рейсов, оставляя только те, у которых время прибытия
     * идет до времени следующего вылета.
     * @param flights Список рейсов, который нужно отфильтровать.
     * @return Список рейсов, у которых время прибытия идет до времени следующего вылета.
     */
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
