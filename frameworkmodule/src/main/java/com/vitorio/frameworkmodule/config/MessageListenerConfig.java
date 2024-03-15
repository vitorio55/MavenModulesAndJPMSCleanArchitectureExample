package com.vitorio.frameworkmodule.config;

import com.vitorio.dataproviderrestmodule.ExternalRestClient;
import com.vitorio.entrypointsqsmodule.MessageListener;
import com.vitorio.entrypointsqsmodule.SqsListener;
import com.vitorio.usecasemodule.boundary.UseCaseFactory;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfig {

    @Bean
    public MessageListener messageListener(DataAccessInterface dataAccessInterface, ExternalRestClient externalRestClient) {
        UseCaseFactory factory = new UseCaseFactory(dataAccessInterface, externalRestClient);
        return new SqsListener(factory);
    }
}
