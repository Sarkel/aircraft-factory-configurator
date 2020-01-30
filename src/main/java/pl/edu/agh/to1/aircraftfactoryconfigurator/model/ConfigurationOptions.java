package pl.edu.agh.to1.aircraftfactoryconfigurator.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConfigurationOptions {
    private List<ModelOption> modelOptions;

    private List<FeatureOption> featureOptions;
}
