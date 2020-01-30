package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.DTOConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AircraftModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.AirCraftModel;

@Service
public class AircraftModelOptionConverter implements DTOConverter<AircraftModelOption, AirCraftModel> {

    @Override
    public AircraftModelOption convert(AirCraftModel source) {
        return AircraftModelOption.builder()
                .id(source.getId())
                .name(source.getName())
                .numberOfSeats(source.getNumberOfSeats())
                .build();
    }
}
