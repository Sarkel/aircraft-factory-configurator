package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.FeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.FeatureRepository;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration.converter.FeatureOptionConverter;

import java.util.List;

@Service
class FeatureConfigurationService {
    private final ListConverter listConverter;
    private final FeatureRepository featureRepository;
    private final FeatureOptionConverter featureOptionConverter;

    FeatureConfigurationService(
            ListConverter listConverter,
            FeatureRepository featureRepository,
            FeatureOptionConverter featureOptionConverter
    ) {
        this.listConverter = listConverter;
        this.featureRepository = featureRepository;
        this.featureOptionConverter = featureOptionConverter;
    }

    List<FeatureOption> getFeatureOptions() {
        return listConverter.convert(
                featureRepository.getAll(),
                featureOptionConverter
        );
    }
}
