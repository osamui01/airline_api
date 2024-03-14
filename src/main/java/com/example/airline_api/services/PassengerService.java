package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

    public Passenger findPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger savePassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmail());
        passengerRepository.save(passenger);
        return passenger;
    }

    public Passenger bookFlight(PassengerDTO passengerDTO, Long id){
        Passenger passengerForFlight = passengerRepository.findById(id).get();
        passengerForFlight.setFlights(new ArrayList<>());

        for (Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightService.findFlightById(flightId);
            passengerForFlight.getFlights().add(flight);
        }
        return passengerRepository.save(passengerForFlight);
    }
}
