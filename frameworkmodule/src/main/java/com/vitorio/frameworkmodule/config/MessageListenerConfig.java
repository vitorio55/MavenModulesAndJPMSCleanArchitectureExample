package com.vitorio.frameworkmodule.config;

import com.vitorio.dataproviderrestmodule.ExternalRestClient;
import com.vitorio.entrypointsqsmodule.MessageListener;
import com.vitorio.entrypointsqsmodule.SqsListener;
import com.vitorio.usecaseinteractormodule.boundary.UseCaseInteractorFactory;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfig {

    @Bean
    public MessageListener messageListener(DataAccessInterface dataAccessInterface, ExternalRestClient externalRestClient) {
        UseCaseInteractorFactory factory = new UseCaseInteractorFactory(dataAccessInterface, externalRestClient);
        return new SqsListener(factory);
    }
}
