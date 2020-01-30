package pl.edu.agh.to1.aircraftfactoryconfigurator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AirCraftConfiguration;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AirCraftConfigurationSelection;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft.AirCraftConfigurationService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "${spring.data.rest.base-path}/air-craft")
public class AirCraftController {
    private final AirCraftConfigurationService airCraftConfigurationService;

    public AirCraftController(AirCraftConfigurationService airCraftConfigurationService) {
        this.airCraftConfigurationService = airCraftConfigurationService;
    }

    @PostMapping("/generate-overview")
    public AirCraftConfiguration generateConfigurationOverview(
            @RequestBody @Valid AirCraftConfigurationSelection airCraftConfigurationSelection
    ) {
        return airCraftConfigurationService.buildConfigurationOverview(airCraftConfigurationSelection);
    }
}
