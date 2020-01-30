package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class AircraftModelOption {
    private Long id;

    private String name;

    private Integer numberOfSeats;

    private BigDecimal price;
}
