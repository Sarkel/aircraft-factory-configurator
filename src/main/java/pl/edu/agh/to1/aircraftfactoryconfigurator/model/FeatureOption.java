package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FeatureOption {
    private final Long id;

    private final String description;

    private final BigDecimal price;
}
