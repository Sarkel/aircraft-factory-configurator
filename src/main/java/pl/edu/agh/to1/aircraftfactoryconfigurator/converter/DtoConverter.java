package pl.edu.agh.to1.aircraftfactoryconfigurator.converter;

public interface DtoConverter<T, V> {
    V convert(T source);
}
