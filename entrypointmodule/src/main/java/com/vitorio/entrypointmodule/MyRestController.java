package com.vitorio.entrypointmodule;

import com.vitorio.usecaseinteractormodule.boundary.InputBoundary;
import com.vitorio.usecaseinteractormodule.boundary.UseCaseInteractorFactory;
import com.vitorio.usecaseinteractormodule.common.UseCase;
import com.vitorio.usecaseinteractormodule.data.InputData;

public class MyRestController {

    private final UseCaseInteractorFactory factory;

    public MyRestController(UseCaseInteractorFactory factory) {
        this.factory = factory;
    }

    // Mock operation
    public int callEndpointCalculateCompany(InputData inputData) {
        InputBoundary ib = factory.createUseCaseInteractor(UseCase.CALCULATE_COMPANY, inputData);
        return ib.interact(inputData);
    }
}
