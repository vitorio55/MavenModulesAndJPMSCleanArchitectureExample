package com.vitorio.entrypointsqsmodule;

import com.vitorio.businessentitymodule.common.CompanyType;
import com.vitorio.usecaseinteractormodule.boundary.InputBoundary;
import com.vitorio.usecaseinteractormodule.boundary.UseCaseInteractorFactory;
import com.vitorio.usecaseinteractormodule.common.UseCase;
import com.vitorio.usecaseinteractormodule.data.InputData;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Mocks the arrival of SQS messages every X seconds

public class SqsListener {

    private static final int SQS_MESSAGES_ARRIVAL_SECONDS = 30;
    private final UseCaseInteractorFactory factory;

    public SqsListener(UseCaseInteractorFactory factory) {
        this.factory = factory;
        InputData messageBody = new InputData(9, 9, CompanyType.FIRST);
        Runnable sqsMessageArrival = () -> receiveSqsMessage(messageBody);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(sqsMessageArrival, 30, SQS_MESSAGES_ARRIVAL_SECONDS, TimeUnit.SECONDS);
    }

    public void receiveSqsMessage(InputData messageBody) {
        UseCase uc = UseCase.CALCULATE_COMPANY;
        System.out.println("SQS Listener will execute " + uc.name() + " use case");
        factory.createUseCaseInteractor(uc, messageBody).interact();
    }
}