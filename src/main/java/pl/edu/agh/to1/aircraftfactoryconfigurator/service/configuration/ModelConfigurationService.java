package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.ModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.ModelRepository;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration.converter.ModelOptionConverter;

import java.util.List;

@Service
class ModelConfigurationService {
    private final ListConverter listConverter;
    private final ModelRepository modelRepository;
    private final ModelOptionConverter modelOptionConverter;

    ModelConfigurationService(
            ListConverter listConverter,
            ModelRepository modelRepository,
            ModelOptionConverter modelOptionConverter
    ) {
        this.listConverter = listConverter;
        this.modelRepository = modelRepository;
        this.modelOptionConverter = modelOptionConverter;
    }

    List<ModelOption> getModelOptions() {
        return listConverter.convert(
                modelRepository.getAll(),
                modelOptionConverter
        );
    }
}
