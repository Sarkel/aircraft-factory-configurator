package pl.edu.agh.to1.aircraftfactoryconfigurator.service.aircraft;

import org.springframework.stereotype.Service;
import pl.edu.agh.to1.aircraftfactoryconfigurator.model.AirCraftConfigurationSelection;
import pl.edu.agh.to1.aircraftfactoryconfigurator.persistence.entity.Model;

import javax.validation.ValidationException;

@Service
class AirCraftSeatsValidator {
    void validateSeats(
            AirCraftConfigurationSelection airCraftConfigurationSelection,
            Model selectedModel
    ) {
        final int totalSelectedSeats = airCraftConfigurationSelection.getBusinessSeats() +
                airCraftConfigurationSelection.getEconomicSeats();
        if (totalSelectedSeats > selectedModel.getNumberOfSeats()) {
            throw new ValidationException("More seats selected then available");
        }
        if (totalSelectedSeats < selectedModel.getNumberOfSeats()) {
            throw new ValidationException("Seats left available for selection");
        }
    }
}
