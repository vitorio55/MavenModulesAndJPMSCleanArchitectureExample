package com.vitorio.frameworkmodule.config;

import com.vitorio.entrypointsqsmodule.SqsListener;
import com.vitorio.usecaseinteractormodule.boundary.UseCaseInteractorFactory;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfig {

    @Bean
    public SqsListener sqsListener(DataAccessInterface dai) {
        UseCaseInteractorFactory factory = new UseCaseInteractorFactory(dai);
        return new SqsListener(factory);
    }
}
