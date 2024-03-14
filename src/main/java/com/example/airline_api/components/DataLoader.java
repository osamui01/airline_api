package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Flight spainFlight = new Flight("Spain", 20, "Friday", "Noon");
        flightRepository.save(spainFlight);

        Passenger johnDoe = new Passenger("John Doe", "jdsports@gmail.com");
        passengerRepository.save(johnDoe);


        Flight japanFlight = new Flight("Japan", 50, "Monday", "Midnight");
        flightRepository.save(japanFlight);

        Passenger janeSmith = new Passenger("Jane Smith", "mrssmith@yahoo.co.uk");
        passengerRepository.save(janeSmith);


        Flight hungaryFlight = new Flight("Hungary", 42, "Tuesday", "Midnight");
        flightRepository.save(hungaryFlight);

        Passenger peterPan = new Passenger("Peter Pan", "ppan99@gmail.com");
        passengerRepository.save(peterPan);
    }

}


