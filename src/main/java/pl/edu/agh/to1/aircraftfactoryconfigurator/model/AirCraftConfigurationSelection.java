package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Data
public class AirCraftConfigurationSelection {
    @NotNull
    private final Long modelId;

    @NotNull
    private final Set<Long> featureIds;

    @NotNull
    @PositiveOrZero
    private final Integer businessSeats;

    @NotNull
    @PositiveOrZero
    private final Integer economicSeats;
}
