package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Feature;

import java.util.List;

public interface AdditionalFeatureRepository extends JpaRepository<Feature, Long> {
    @Query("select af from Feature af")
    List<Feature> getAll();
}
