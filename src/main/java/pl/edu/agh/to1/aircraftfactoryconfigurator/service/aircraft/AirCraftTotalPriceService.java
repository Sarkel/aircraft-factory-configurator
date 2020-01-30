package pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Feature;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Model;

import java.math.BigDecimal;
import java.util.List;

@Service
class AirCraftTotalPriceService {
    BigDecimal getTotalPrice(Model model, List<Feature> features) {
        return features.stream()
                .map(Feature::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .add(model.getPrice());
    }
}
