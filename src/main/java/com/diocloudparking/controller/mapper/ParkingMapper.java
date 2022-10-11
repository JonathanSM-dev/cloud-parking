package com.diocloudparking.controller.mapper;

import com.diocloudparking.controller.dto.ParkingCreateDTO;
import com.diocloudparking.controller.dto.ParkingDTO;
import com.diocloudparking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static Parking toParkingCreate(ParkingCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }

    public ParkingDTO toParkingDTO(Parking parking){
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public static Parking toParking(ParkingCreateDTO dto){
        return MODEL_MAPPER.map(dto, Parking.class);
    }


}
