package pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft.description;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class FullDescriptionDetails {
    private String modelName;

    private int economicSeats;

    private int businessSeats;

    private BigDecimal price;

    private Set<String> featureDescriptions;
}
