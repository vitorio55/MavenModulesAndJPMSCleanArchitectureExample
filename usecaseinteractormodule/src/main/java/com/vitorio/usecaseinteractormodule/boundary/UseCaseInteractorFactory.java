package com.vitorio.usecaseinteractormodule.boundary;

import com.vitorio.businessentitymodule.CompanyCalculations;
import com.vitorio.businessentitymodule.CompanyCalculationsFactory;
import com.vitorio.usecaseinteractormodule.CalculateCompanyUseCaseInteractor;
import com.vitorio.usecaseinteractormodule.common.UseCase;
import com.vitorio.usecaseinteractormodule.data.InputData;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;

public class UseCaseInteractorFactory {

    private final DataAccessInterface dataAccessInterface;
    private final OutputBoundary externalClient;

    public UseCaseInteractorFactory(DataAccessInterface dataAccessInterface, OutputBoundary externalClient) {
        this.dataAccessInterface = dataAccessInterface;
        this.externalClient = externalClient;
    }

    public InputBoundary createUseCaseInteractor(UseCase useCase, InputData inputData) {
        if (useCase == UseCase.CALCULATE_COMPANY) {
            CompanyCalculationsFactory ccf = new CompanyCalculationsFactory();
            CompanyCalculations companyCalculations = ccf.createCompanyCalculations(inputData.val0(),
                inputData.val1(), inputData.companyType());
            return new CalculateCompanyUseCaseInteractor(companyCalculations, dataAccessInterface, externalClient);
        }
        System.out.println("No use case selected!!");
        return null;
    }
}
