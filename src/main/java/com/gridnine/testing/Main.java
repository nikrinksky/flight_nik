package com.gridnine.testing;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println(flightList.stream().toList());

        System.out.println("Фильтрация вылетов:");

        FlightFilter flightFiltersDeparture = new DepartureFilterUpToCurrentTime();
        System.out.println("Отфильтрованные рейсы, вылет которых, происходит до текущего момента времени");
        System.out.println(flightFiltersDeparture.filterFlights(flightList));

        FlightFilter flightFiltersArrival = new ArrivalFilterBeforeDepartureDate();
        System.out.println("Отфильтрованные рейсы, прибытие которых, перед датой вылета");
        System.out.println(flightFiltersArrival.filterFlights(flightList));

        FlightFilter flightFiltersInterval = new FilterIntervalBetweenArrivalAndDeparture();
        System.out.println("Отфильтрованные рейсы, интервал которых между прилётом и вылетом, превышающий два часа");
        System.out.println(flightFiltersInterval.filterFlights(flightList));


    }


}
