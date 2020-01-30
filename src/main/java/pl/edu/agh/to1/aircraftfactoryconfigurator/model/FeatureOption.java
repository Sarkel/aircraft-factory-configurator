package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FeatureOption {
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;
}
