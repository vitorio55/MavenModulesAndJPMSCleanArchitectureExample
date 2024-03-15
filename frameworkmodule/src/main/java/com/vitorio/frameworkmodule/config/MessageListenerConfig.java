package com.vitorio.frameworkmodule.config;

import com.vitorio.entrypointsqsmodule.MessageListener;
import com.vitorio.entrypointsqsmodule.SqsListener;
import com.vitorio.usecasemodule.UseCaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfig {

    @Bean
    public MessageListener messageListener(UseCaseFactory factory) {
        return new SqsListener(factory);
    }
}
