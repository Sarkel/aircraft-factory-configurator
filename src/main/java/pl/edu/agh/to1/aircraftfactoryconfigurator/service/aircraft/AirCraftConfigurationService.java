package pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.converter.ListConverter;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AirCraftConfiguration;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AirCraftConfigurationSelection;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Feature;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Model;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.FeatureRepository;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository.ModelRepository;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft.description.FullDescriptionBuilder;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft.description.FullDescriptionDetails;
import pl.edu.agh.to1.aircraftfactoryconfigurator.service.configuration.converter.FeatureOptionConverter;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AirCraftConfigurationService {
    private final ModelRepository modelRepository;
    private final FeatureRepository featureRepository;
    private final FeatureOptionConverter featureOptionConverter;
    private final ListConverter listConverter;
    private final AirCraftTotalPriceService airCraftTotalPriceService;
    private final AirCraftSeatsValidator airCraftSeatsValidator;
    private final FullDescriptionBuilder fullDescriptionBuilder;

    public AirCraftConfigurationService(
            ModelRepository modelRepository,
            FeatureRepository featureRepository,
            FeatureOptionConverter featureOptionConverter,
            ListConverter listConverter,
            AirCraftTotalPriceService airCraftTotalPriceService,
            AirCraftSeatsValidator airCraftSeatsValidator,
            FullDescriptionBuilder fullDescriptionBuilder
    ) {
        this.modelRepository = modelRepository;
        this.featureRepository = featureRepository;
        this.featureOptionConverter = featureOptionConverter;
        this.listConverter = listConverter;
        this.airCraftTotalPriceService = airCraftTotalPriceService;
        this.airCraftSeatsValidator = airCraftSeatsValidator;
        this.fullDescriptionBuilder = fullDescriptionBuilder;
    }

    public AirCraftConfiguration buildConfigurationOverview(
            AirCraftConfigurationSelection airCraftConfigurationSelection
    ) {
        final Model selectedModel = modelRepository.getById(airCraftConfigurationSelection.getModelId())
                .orElseThrow(() -> new EntityNotFoundException("Model does not exist"));

        airCraftSeatsValidator.validateSeats(airCraftConfigurationSelection, selectedModel);

        final List<Feature> features = featureRepository.getByIds(airCraftConfigurationSelection.getFeatureIds());

        final BigDecimal totalPrice = airCraftTotalPriceService.getTotalPrice(selectedModel, features);

        return AirCraftConfiguration.builder()
                .businessSeats(airCraftConfigurationSelection.getBusinessSeats())
                .economicSeats(airCraftConfigurationSelection.getEconomicSeats())
                .description(
                        fullDescriptionBuilder.build(
                                FullDescriptionDetails.builder()
                                .businessSeats(airCraftConfigurationSelection.getBusinessSeats())
                                .economicSeats(airCraftConfigurationSelection.getEconomicSeats())
                                .featureDescriptions(getFeatureDescriptions(features))
                                .modelName(selectedModel.getName())
                                .price(totalPrice)
                                .build()
                        )
                )
                .modelName(selectedModel.getName())
                .features(listConverter.convert(features, featureOptionConverter))
                .totalPrice(totalPrice)
                .build();
    }

    private Set<String> getFeatureDescriptions(List<Feature> features) {
        return features.stream()
                .map(Feature::getDescription)
                .collect(Collectors.toSet());
    }
}
