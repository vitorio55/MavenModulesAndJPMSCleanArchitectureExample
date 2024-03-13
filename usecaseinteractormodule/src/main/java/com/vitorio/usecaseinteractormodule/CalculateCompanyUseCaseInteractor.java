package com.vitorio.usecaseinteractormodule;

import com.vitorio.businessentitymodule.CompanyCalculations;
import com.vitorio.usecaseinteractormodule.boundary.OutputBoundary;
import com.vitorio.usecaseinteractormodule.data.OutputData;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;
import com.vitorio.usecaseinteractormodule.boundary.InputBoundary;

public class CalculateCompanyUseCaseInteractor implements InputBoundary {

    private final CompanyCalculations companyCalculations;
    private final DataAccessInterface dataAccessInterface;
    private final OutputBoundary externalRestClient;

    public CalculateCompanyUseCaseInteractor(CompanyCalculations companyCalculations, DataAccessInterface dataAccessInterface,
                                             OutputBoundary externalRestClient) {
        this.companyCalculations = companyCalculations;
        this.dataAccessInterface = dataAccessInterface;
        this.externalRestClient = externalRestClient;
    }

    @Override
    public int interact() {
        System.out.println("Calculated: " + companyCalculations.calc());
        int calculated = companyCalculations.calc();
        dataAccessInterface.saveCalcResult(calculated);
        OutputData od = new OutputData(calculated);
        externalRestClient.interact(od);
        return calculated;
    }
}
