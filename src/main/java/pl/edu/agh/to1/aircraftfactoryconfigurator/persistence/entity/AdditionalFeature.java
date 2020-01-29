package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
public class AdditionalFeature {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<AirCraft> airCrafts;
}
