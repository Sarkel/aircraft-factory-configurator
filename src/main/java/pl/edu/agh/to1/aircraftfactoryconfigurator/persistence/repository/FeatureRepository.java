package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Feature;

import java.util.List;
import java.util.Set;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    @Query("select f from Feature f")
    List<Feature> getAll();

    @Query("select f from Feature f WHERE f.id in ?1")
    List<Feature> getByIds(Set<Long> featureIds);
}
