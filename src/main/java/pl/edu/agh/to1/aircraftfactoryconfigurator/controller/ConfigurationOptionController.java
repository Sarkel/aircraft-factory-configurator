package pl.edu.agh.to1.aircraftfactoryconfigurator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.FeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.ModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.feature.FeatureOptionService;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.model.ModelOptionService;

import java.util.List;

@RestController
@RequestMapping("/configuration-options")
public class ConfigurationOptionController {

    private final ModelOptionService modelOptionService;
    private final FeatureOptionService additionalFeatureOptionService;

    @Autowired
    public ConfigurationOptionController(
            ModelOptionService modelOptionService,
            FeatureOptionService additionalFeatureOptionService
    ) {
        this.modelOptionService = modelOptionService;
        this.additionalFeatureOptionService = additionalFeatureOptionService;
    }

    @GetMapping("/model")
    public List<ModelOption> getModels() {
        return modelOptionService.getModelOptions();
    }

    @GetMapping("/features")
    public List<FeatureOption> getFeatures() {
        return additionalFeatureOptionService.getAdditionalFeatureOptions();
    }
}
