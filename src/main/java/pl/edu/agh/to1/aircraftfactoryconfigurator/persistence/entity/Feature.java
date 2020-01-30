package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
public class Feature {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private BigDecimal price;
}
