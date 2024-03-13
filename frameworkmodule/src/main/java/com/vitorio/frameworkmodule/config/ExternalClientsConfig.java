package com.vitorio.frameworkmodule.config;

import com.vitorio.dataproviderrestmodule.ExternalRestClient;
import com.vitorio.usecaseinteractormodule.boundary.OutputBoundary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalClientsConfig {

    @Bean
    public OutputBoundary externalClient() {
        return new ExternalRestClient();
    }
}
