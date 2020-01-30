package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Builder;
import lombok.Data;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Feature;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Model;

import java.util.List;

@Builder
@Data
public class AirCraftConfiguration {
    private Integer economicSeats;

    private Integer businessSeats;

    private List<Feature> features;

    private Model model;
}
