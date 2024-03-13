package com.vitorio.usecaseinteractormodule;

import com.vitorio.businessentitymodule.CompanyCalculations;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;
import com.vitorio.usecaseinteractormodule.boundary.InputBoundary;

public class CalculateCompanyUseCaseInteractor implements InputBoundary {

    private final CompanyCalculations companyCalculations;
    private final DataAccessInterface dataAccessInterface;

    public CalculateCompanyUseCaseInteractor(CompanyCalculations companyCalculations, DataAccessInterface dataAccessInterface) {
        this.companyCalculations = companyCalculations;
        this.dataAccessInterface = dataAccessInterface;
    }

    @Override
    public int interact() {
        System.out.println("Calculated: " + companyCalculations.calc());
        int calculated = companyCalculations.calc();
        dataAccessInterface.saveCalcResult(calculated);
        return calculated;
    }
}
