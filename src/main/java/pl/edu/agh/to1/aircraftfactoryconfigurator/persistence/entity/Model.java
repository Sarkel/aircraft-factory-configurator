package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
public class Model {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer numberOfSeats;

    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AirCraft> airCrafts;
}
