package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AircraftModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.AirCraftModelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConfigurationOptionService {
    private final AirCraftModelRepository airCraftModelRepository;
    private final AircraftModelOptionConverter aircraftModelOptionConverter;

    @Autowired
    public ConfigurationOptionService(
            AirCraftModelRepository airCraftModelRepository,
            AircraftModelOptionConverter aircraftModelOptionConverter
    ) {
        this.airCraftModelRepository = airCraftModelRepository;
        this.aircraftModelOptionConverter = aircraftModelOptionConverter;
    }

    public List<AircraftModelOption> getModelOptions() {
        return airCraftModelRepository.getAll()
                .stream()
                .map(aircraftModelOptionConverter::convert)
                .collect(Collectors.toList());
    }
}
