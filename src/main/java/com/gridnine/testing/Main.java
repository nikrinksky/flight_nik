package com.gridnine.testing;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println(flightList.stream().toList());

        System.out.println("Фильтрация вылетов:");

        FlightFilter flightFiltersDeparture = new DepartureFilterUpToCurrentTime();
        System.out.println("Фильтрует список рейсов, оставляя только те, вылет которых, происходит после текущего времени");
        System.out.println(flightFiltersDeparture.filterFlights(flightList));

        FlightFilter flightFiltersArrival = new ArrivalFilterBeforeDepartureDate();
        System.out.println("Фильтрует список рейсов, оставляя только те, у которых время прибытия идет до времени следующего вылета.");
        System.out.println(flightFiltersArrival.filterFlights(flightList));

        FlightFilter flightFiltersInterval = new FilterIntervalBetweenArrivalAndDeparture();
        System.out.println("Фильтрует список рейсов, оставляя только те, интервал которых между прилётом и вылетом, не превышает два часа");
        System.out.println(flightFiltersInterval.filterFlights(flightList));


    }


}
