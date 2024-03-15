package com.vitorio.usecasemodule;

import com.vitorio.businessentitymodule.CompanyCalculations;
import com.vitorio.businessentitymodule.CompanyCalculationsFactory;
import com.vitorio.usecasemodule.boundary.InputBoundary;
import com.vitorio.usecasemodule.boundary.OutputBoundary;
import com.vitorio.usecasemodule.common.UseCase;
import com.vitorio.usecasemodule.data.InputData;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;

public class UseCaseFactoryImpl implements UseCaseFactory {

    private final DataAccessInterface dataAccessInterface;
    private final OutputBoundary externalClient;

    public UseCaseFactoryImpl(DataAccessInterface dataAccessInterface, OutputBoundary externalClient) {
        this.dataAccessInterface = dataAccessInterface;
        this.externalClient = externalClient;
    }

    @Override
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
