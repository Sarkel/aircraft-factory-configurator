package pl.edu.agh.to1.aircraftfactoryconfigurator.converter;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListConverter {
    public <T, V> List<V> convert(List<T> source, DtoConverter<T, V> converter) {
        return source.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
