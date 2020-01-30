package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class AirCraftConfigurationSelection {
    @NotNull
    private final Long modelId;

    @NotNull
    private final Set<Long> featureIds;

    private final Integer businessSeats;

    private final Integer economicSeats;
}
