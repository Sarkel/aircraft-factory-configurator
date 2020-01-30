package pl.edu.agh.to1.aircraftfactoryconfigurator.converter;

public interface DTOConverter<T, V> {
    T convert(V source);
}
