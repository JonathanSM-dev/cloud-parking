package com.diocloudparking.Service;

import com.diocloudparking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static  Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "JSM-7777", "GO", "CELTA", "PRETO");
        Parking parking1 = new Parking(id1, "JSM-7778", "PR", "GOL", "CINZA");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }
}
