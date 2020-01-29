package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AirCraft {
    @Id
    @GeneratedValue
    private Long id;

    private Integer economicSeats;

    private Integer businessSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    private AirCraftModel model;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<AdditionalFeature> features;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
