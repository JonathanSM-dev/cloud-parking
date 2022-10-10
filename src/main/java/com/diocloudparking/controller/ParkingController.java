package com.diocloudparking.controller;

import com.diocloudparking.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @GetMapping
    public List<Parking> findAll(){
        var parking = new Parking();
        parking.setColor("BLACK");
        parking.setLicense("JSM-7777");
        parking.setModel("VW GOL");
        parking.setState("GO");

        return Arrays.asList(parking);

    }
}
