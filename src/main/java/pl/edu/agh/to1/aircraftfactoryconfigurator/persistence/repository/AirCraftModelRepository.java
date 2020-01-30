package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.AirCraftModel;

import java.util.List;

public interface AirCraftModelRepository extends JpaRepository<AirCraftModel, Long> {
    @Query("select acm from AirCraftModel acm")
    List<AirCraftModel> getAll();
}
