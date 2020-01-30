package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.feature;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AdditionalFeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.AdditionalFeatureRepository;

import java.util.List;

@Service
public class AdditionalFeatureOptionService {
    private final AdditionalFeatureRepository additionalFeatureRepository;
    private final AdditionalFeatureOptionConverter additionalFeatureOptionConverter;
    private final ListConverter listConverter;

    public AdditionalFeatureOptionService(
            AdditionalFeatureRepository additionalFeatureRepository,
            AdditionalFeatureOptionConverter additionalFeatureOptionConverter,
            ListConverter listConverter
    ) {
        this.additionalFeatureRepository = additionalFeatureRepository;
        this.additionalFeatureOptionConverter = additionalFeatureOptionConverter;
        this.listConverter = listConverter;
    }

    public List<AdditionalFeatureOption> getAdditionalFeatureOptions() {
        return listConverter.convert(
                additionalFeatureRepository.getAll(),
                additionalFeatureOptionConverter
        );
    }
}
