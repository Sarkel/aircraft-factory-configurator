package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class AirCraftConfiguration {
    private Integer economicSeats;

    private Integer businessSeats;

    private String description;

    private BigDecimal totalPrice;

    private List<FeatureOption> features;

    private String modelName;
}
