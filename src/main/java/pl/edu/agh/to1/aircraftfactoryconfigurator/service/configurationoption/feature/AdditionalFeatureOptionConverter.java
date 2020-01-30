package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.feature;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.DTOConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AdditionalFeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.AdditionalFeature;

@Service
public class AdditionalFeatureOptionConverter implements DTOConverter<AdditionalFeatureOption, AdditionalFeature> {
    @Override
    public AdditionalFeatureOption convert(AdditionalFeature source) {
        return AdditionalFeatureOption.builder()
                .id(source.getId())
                .description(source.getDescription())
                .price(source.getPrice())
                .name(source.getName())
                .build();
    }
}
