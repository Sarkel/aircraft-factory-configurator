package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AirCraft> airCrafts;
}
