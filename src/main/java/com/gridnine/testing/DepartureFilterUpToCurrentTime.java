package com.gridnine.testing;



import java.util.List;

public class DepartureFilterUpToCurrentTime implements FlightFilter{
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        // Реализация фильтрации по вылету до текущего момента времени
        return flights;
    }

}
