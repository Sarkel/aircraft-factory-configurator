package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.feature;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.DTOConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.FeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Feature;

@Service
public class FeatureOptionConverter implements DTOConverter<FeatureOption, Feature> {
    @Override
    public FeatureOption convert(Feature source) {
        return FeatureOption.builder()
                .id(source.getId())
                .description(source.getDescription())
                .price(source.getPrice())
                .name(source.getName())
                .build();
    }
}
