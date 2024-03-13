package com.vitorio.usecaseinteractormodule.boundary;

import com.vitorio.businessentitymodule.CompanyCalculations;
import com.vitorio.businessentitymodule.CompanyCalculationsFactory;
import com.vitorio.usecaseinteractormodule.CalculateCompanyUseCaseInteractor;
import com.vitorio.usecaseinteractormodule.common.UseCase;
import com.vitorio.usecaseinteractormodule.data.InputData;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;

public class UseCaseInteractorFactory {

    private final DataAccessInterface dataAccessInterface;

    public UseCaseInteractorFactory(DataAccessInterface dai) {
        this.dataAccessInterface = dai;
    }

    public InputBoundary createUseCaseInteractor(UseCase useCase, InputData inputData) {
        if (useCase == UseCase.CALCULATE_COMPANY) {
            CompanyCalculationsFactory ccf = new CompanyCalculationsFactory();
            CompanyCalculations companyCalculations = ccf.createCompanyCalculations(inputData.getVal0(),
                inputData.getVal1(), inputData.getCompanyType());
            return new CalculateCompanyUseCaseInteractor(companyCalculations, dataAccessInterface);
        }
        System.out.println("No use case selected!!");
        return null;
    }
}
