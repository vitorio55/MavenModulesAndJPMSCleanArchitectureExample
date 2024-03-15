package com.vitorio.usecasemodule.boundary;

import com.vitorio.businessentitymodule.CompanyCalculations;
import com.vitorio.businessentitymodule.CompanyCalculationsFactory;
import com.vitorio.usecasemodule.CalculateCompanyUseCase;
import com.vitorio.usecasemodule.common.UseCase;
import com.vitorio.usecasemodule.data.InputData;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;

public class UseCaseFactory {

    private final DataAccessInterface dataAccessInterface;
    private final OutputBoundary externalClient;

    public UseCaseFactory(DataAccessInterface dataAccessInterface, OutputBoundary externalClient) {
        this.dataAccessInterface = dataAccessInterface;
        this.externalClient = externalClient;
    }

    public InputBoundary createUseCase(UseCase useCase, InputData inputData) {
        if (useCase == UseCase.CALCULATE_COMPANY) {
            CompanyCalculationsFactory ccf = new CompanyCalculationsFactory();
            CompanyCalculations companyCalculations = ccf.createCompanyCalculations(inputData.val0(),
                inputData.val1(), inputData.companyType());
            return new CalculateCompanyUseCase(companyCalculations, dataAccessInterface, externalClient);
        }
        System.out.println("No use case selected!!");
        return null;
    }
}
