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
    private Model model;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Feature> features;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser user;
}
