package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
public class Model {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer numberOfSeats;

    private BigDecimal price;
}
