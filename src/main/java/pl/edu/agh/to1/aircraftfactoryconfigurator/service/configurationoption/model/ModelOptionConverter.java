package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.model;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.DTOConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.ModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Model;

@Service
public class ModelOptionConverter implements DTOConverter<ModelOption, Model> {

    @Override
    public ModelOption convert(Model source) {
        return ModelOption.builder()
                .id(source.getId())
                .name(source.getName())
                .numberOfSeats(source.getNumberOfSeats())
                .build();
    }
}
