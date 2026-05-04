package com.hewhorizon.hrms.saas.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration()
                .setSkipNullEnabled(true)        // ignore null values
                .setAmbiguityIgnored(true);      // ignore duplicate mappings

        return mapper;
    }
}