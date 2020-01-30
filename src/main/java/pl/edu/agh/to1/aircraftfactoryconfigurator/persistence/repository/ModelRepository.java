package pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Model;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    @Query("select m from Model m")
    List<Model> getAll();
}
