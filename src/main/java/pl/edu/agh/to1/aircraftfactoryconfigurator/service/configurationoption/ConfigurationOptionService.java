package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AdditionalFeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AircraftModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.AdditionalFeatureRepository;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.AirCraftModelRepository;

import java.util.List;

@Service
public class ConfigurationOptionService {
    private final AirCraftModelRepository airCraftModelRepository;
    private final AdditionalFeatureRepository additionalFeatureRepository;
    private final AircraftModelOptionConverter aircraftModelOptionConverter;
    private final AdditionalFeatureOptionConverter additionalFeatureOptionConverter;
    private final ListConverter listConverter;

    @Autowired
    public ConfigurationOptionService(
            AirCraftModelRepository airCraftModelRepository,
            AdditionalFeatureRepository additionalFeatureRepository,
            AircraftModelOptionConverter aircraftModelOptionConverter,
            AdditionalFeatureOptionConverter additionalFeatureOptionConverter,
            ListConverter listConverter
    ) {
        this.airCraftModelRepository = airCraftModelRepository;
        this.additionalFeatureRepository = additionalFeatureRepository;
        this.aircraftModelOptionConverter = aircraftModelOptionConverter;
        this.additionalFeatureOptionConverter = additionalFeatureOptionConverter;
        this.listConverter = listConverter;
    }

    public List<AircraftModelOption> getModelOptions() {
        return listConverter.convert(
                airCraftModelRepository.getAll(),
                aircraftModelOptionConverter
        );
    }

    public List<AdditionalFeatureOption> getAdditionalFeatureOptions() {
        return listConverter.convert(
                additionalFeatureRepository.getAll(),
                additionalFeatureOptionConverter
        );
    }
}
