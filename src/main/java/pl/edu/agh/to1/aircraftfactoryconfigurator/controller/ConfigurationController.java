package pl.edu.agh.to1.aircraftfactoryconfigurator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.ConfigurationOptions;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration.ConfigurationService;

@RestController
@RequestMapping(value = "${spring.data.rest.base-path}/configuration")
public class ConfigurationController {
    private final ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @RequestMapping
    public ConfigurationOptions getConfigurations() {
        return configurationService.getConfiguration();
    }
}

