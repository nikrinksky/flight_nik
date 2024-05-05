package com.gridnine.testing;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println(flightList.stream().toList());

        FlightFilter flightFilters = new ArrivalFilterBeforeDepartureDate();
        //flightFilters.filterFlights(flightList);
        System.out.println("---------------------------------");
        System.out.println(flightFilters.filterFlights(flightList));
    }


}
