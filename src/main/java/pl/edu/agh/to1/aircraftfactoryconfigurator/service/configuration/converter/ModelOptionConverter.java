package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration.converter;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.DtoConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.ModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Model;

@Service
public class ModelOptionConverter implements DtoConverter<Model, ModelOption> {
    @Override
    public ModelOption convert(@NonNull Model source) {
        return ModelOption.builder()
                .id(source.getId())
                .name(source.getName())
                .numberOfSeats(source.getNumberOfSeats())
                .price(source.getPrice())
                .build();
    }
}
