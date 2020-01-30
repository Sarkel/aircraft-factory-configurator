package pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.ConfigurationOptions;

@Service
public class ConfigurationService {
    private final FeatureConfigurationService featureConfigurationService;
    private final ModelConfigurationService modelConfigurationService;

    public ConfigurationService(
            FeatureConfigurationService featureConfigurationService,
            ModelConfigurationService modelConfigurationService
    ) {
        this.featureConfigurationService = featureConfigurationService;
        this.modelConfigurationService = modelConfigurationService;
    }

    public ConfigurationOptions getConfiguration() {
        return ConfigurationOptions.builder()
                .featureOptions(featureConfigurationService.getFeatureOptions())
                .modelOptions(modelConfigurationService.getModelOptions())
                .build();
    }
}
