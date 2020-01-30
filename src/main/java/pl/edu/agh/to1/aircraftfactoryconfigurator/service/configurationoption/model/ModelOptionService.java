package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.model;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AircraftModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.AirCraftModelRepository;

import java.util.List;

@Service
public class ModelOptionService {
    private final AirCraftModelRepository airCraftModelRepository;
    private final ModelOptionConverter aircraftModelOptionConverter;
    private final ListConverter listConverter;

    public ModelOptionService(
            AirCraftModelRepository airCraftModelRepository,
            ModelOptionConverter aircraftModelOptionConverter,
            ListConverter listConverter
    ) {
        this.airCraftModelRepository = airCraftModelRepository;
        this.aircraftModelOptionConverter = aircraftModelOptionConverter;
        this.listConverter = listConverter;
    }

    public List<AircraftModelOption> getModelOptions() {
        return listConverter.convert(
                airCraftModelRepository.getAll(),
                aircraftModelOptionConverter
        );
    }
}
