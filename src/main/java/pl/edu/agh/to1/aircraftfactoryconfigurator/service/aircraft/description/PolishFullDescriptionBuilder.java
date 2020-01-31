package pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft.description;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PolishFullDescriptionBuilder implements FullDescriptionBuilder {
    @Override
    public String build(FullDescriptionDetails descriptionDetails) {
        StringBuilder descriptionBuilder = new StringBuilder();

        descriptionBuilder.append(descriptionDetails.getModelName());
        descriptionBuilder.append(" z układem foteli ");
        descriptionBuilder.append(descriptionDetails.getEconomicSeats());
        descriptionBuilder.append("-");
        descriptionBuilder.append(descriptionDetails.getBusinessSeats());
        descriptionBuilder.append(" (klasa ekonomiczna - biznesowa), z ");
        descriptionBuilder.append(getFeatureDescription(descriptionDetails.getFeatureDescriptions()));
        descriptionBuilder.append(". Cena samolotu: ");
        descriptionBuilder.append(getFormattedTotal(descriptionDetails.getPrice()));
        descriptionBuilder.append(" zł.");

        return descriptionBuilder.toString();
    }

    private String getFormattedTotal(BigDecimal price) {
        return String.format(Locale.ENGLISH, "%,.2f", price.setScale(2, RoundingMode.HALF_EVEN));
    }

    private String getFeatureDescription(Set<String> uniqueFeatureDescriptions) {
        final List<String> featureDescriptions = new ArrayList<>(uniqueFeatureDescriptions);

        return String.join(
                ", ",
                featureDescriptions.stream()
                        .limit(featureDescriptions.size() - 1)
                        .collect(Collectors.toSet())
        ) + " i " + featureDescriptions.get(featureDescriptions.size() - 1);
    }
}
