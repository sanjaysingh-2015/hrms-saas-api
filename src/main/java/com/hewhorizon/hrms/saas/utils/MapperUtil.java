package com.hewhorizon.hrms.saas.utils;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperUtil {

    private final ModelMapper mapper;

    public <S, T> T map(S source, Class<T> targetClass) {
        return mapper.map(source, targetClass);
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream()
                .map(s -> map(s, targetClass))
                .toList();
    }
}