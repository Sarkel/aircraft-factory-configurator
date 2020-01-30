package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.AdditionalFeature;

import java.util.List;

public interface AdditionalFeatureRepository extends JpaRepository<AdditionalFeature, Long> {
    @Query("select af from AdditionalFeature af")
    List<AdditionalFeature> getAll();
}
