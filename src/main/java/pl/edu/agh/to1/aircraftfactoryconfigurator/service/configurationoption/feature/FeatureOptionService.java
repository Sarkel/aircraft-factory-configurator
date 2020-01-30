package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.feature;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.FeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.AdditionalFeatureRepository;

import java.util.List;

@Service
public class FeatureOptionService {
    private final AdditionalFeatureRepository additionalFeatureRepository;
    private final FeatureOptionConverter additionalFeatureOptionConverter;
    private final ListConverter listConverter;

    public FeatureOptionService(
            AdditionalFeatureRepository additionalFeatureRepository,
            FeatureOptionConverter additionalFeatureOptionConverter,
            ListConverter listConverter
    ) {
        this.additionalFeatureRepository = additionalFeatureRepository;
        this.additionalFeatureOptionConverter = additionalFeatureOptionConverter;
        this.listConverter = listConverter;
    }

    public List<FeatureOption> getAdditionalFeatureOptions() {
        return listConverter.convert(
                additionalFeatureRepository.getAll(),
                additionalFeatureOptionConverter
        );
    }
}
