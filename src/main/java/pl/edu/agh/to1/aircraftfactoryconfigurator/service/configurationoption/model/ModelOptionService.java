package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.model;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.ModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.ModelRepository;

import java.util.List;

@Service
public class ModelOptionService {
    private final ModelRepository airCraftModelRepository;
    private final ModelOptionConverter aircraftModelOptionConverter;
    private final ListConverter listConverter;

    public ModelOptionService(
            ModelRepository airCraftModelRepository,
            ModelOptionConverter aircraftModelOptionConverter,
            ListConverter listConverter
    ) {
        this.airCraftModelRepository = airCraftModelRepository;
        this.aircraftModelOptionConverter = aircraftModelOptionConverter;
        this.listConverter = listConverter;
    }

    public List<ModelOption> getModelOptions() {
        return listConverter.convert(
                airCraftModelRepository.getAll(),
                aircraftModelOptionConverter
        );
    }
}
