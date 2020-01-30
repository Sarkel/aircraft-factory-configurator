package pl.edu.agh.to1.aircraftfactoryconfigurator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AdditionalFeatureOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AircraftModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.feature.AdditionalFeatureOptionService;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.model.ModelOptionService;

import java.util.List;

@RestController
@RequestMapping("/configuration-options")
public class ConfigurationOptionController {

    private final ModelOptionService modelOptionService;
    private final AdditionalFeatureOptionService additionalFeatureOptionService;

    @Autowired
    public ConfigurationOptionController(
            ModelOptionService modelOptionService,
            AdditionalFeatureOptionService additionalFeatureOptionService
    ) {
        this.modelOptionService = modelOptionService;
        this.additionalFeatureOptionService = additionalFeatureOptionService;
    }

    @GetMapping("/model")
    public List<AircraftModelOption> getModels() {
        return modelOptionService.getModelOptions();
    }

    @GetMapping("/features")
    public List<AdditionalFeatureOption> getFeatures() {
        return additionalFeatureOptionService.getAdditionalFeatureOptions();
    }
}
