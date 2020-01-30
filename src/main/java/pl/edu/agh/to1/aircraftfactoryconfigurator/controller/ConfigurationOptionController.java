package pl.edu.agh.to1.aircraftfactoryconfigurator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AircraftModelOption;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configurationoption.ConfigurationOptionService;

import java.util.List;

@RestController
@RequestMapping("/configuration-options")
public class ConfigurationOptionController {

    private final ConfigurationOptionService configurationService;

    @Autowired
    public ConfigurationOptionController(ConfigurationOptionService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping("/model")
    public List<AircraftModelOption> getModels() {
        return configurationService.getModelOptions();
    }
}
