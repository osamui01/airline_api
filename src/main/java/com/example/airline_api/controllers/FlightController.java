package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;
    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id){
        return new ResponseEntity<>(flightService.findFlightById(id), HttpStatus.OK);
    }

    // Add new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Cancel flight
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity cancelFlight(){
//        return null;
//    }

}
