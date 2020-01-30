package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration.converter;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.DtoConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.FeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Feature;

@Service
public class FeatureOptionConverter implements DtoConverter<Feature, FeatureOption> {

    @Override
    public FeatureOption convert(@NonNull Feature source) {
        return FeatureOption.builder()
                .description(source.getDescription())
                .id(source.getId())
                .price(source.getPrice())
                .build();
    }
}
