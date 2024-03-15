package com.vitorio.frameworkmodule.config;

import com.vitorio.usecasemodule.boundary.OutputBoundary;
import com.vitorio.usecasemodule.UseCaseFactory;
import com.vitorio.usecasemodule.UseCaseFactoryImpl;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public UseCaseFactory useCaseFactory(DataAccessInterface dataAccessInterface, OutputBoundary externalClient) {
        return new UseCaseFactoryImpl(dataAccessInterface, externalClient);
    }
}
