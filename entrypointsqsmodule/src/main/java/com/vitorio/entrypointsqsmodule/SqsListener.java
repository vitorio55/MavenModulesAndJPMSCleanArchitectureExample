package com.vitorio.entrypointsqsmodule;

import com.vitorio.businessentitymodule.common.CompanyType;
import com.vitorio.usecasemodule.UseCaseFactory;
import com.vitorio.usecasemodule.common.UseCase;
import com.vitorio.usecasemodule.data.InputData;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SqsListener implements MessageListener {

    private static final int SQS_MESSAGES_ARRIVAL_SECONDS = 30;
    private final UseCaseFactory factory;

    public SqsListener(UseCaseFactory factory) {
        // Mocks the arrival of SQS messages every X seconds
        this.factory = factory;
        InputData messageBody = new InputData(9, 9, CompanyType.FIRST);
        Runnable sqsMessageArrival = () -> receiveMessage(messageBody);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(sqsMessageArrival, 15, SQS_MESSAGES_ARRIVAL_SECONDS, TimeUnit.SECONDS);
    }

    @Override
    public void receiveMessage(InputData messageBody) {
        UseCase uc = UseCase.CALCULATE_COMPANY;
        System.out.println("SQS Listener will execute " + uc.name() + " use case");
        factory.createUseCase(uc, messageBody).interact();
    }
}
