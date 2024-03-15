package com.vitorio.usecasemodule;

import com.vitorio.businessentitymodule.CompanyCalculations;
import com.vitorio.usecasemodule.boundary.OutputBoundary;
import com.vitorio.usecasemodule.data.OutputData;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;
import com.vitorio.usecasemodule.boundary.InputBoundary;

public class CalculateCompanyUseCase implements InputBoundary {

    private final CompanyCalculations companyCalculations;
    private final DataAccessInterface dataAccessInterface;
    private final OutputBoundary outputBoundary;

    public CalculateCompanyUseCase(CompanyCalculations companyCalculations, DataAccessInterface dataAccessInterface,
                                   OutputBoundary outputBoundary) {
        this.companyCalculations = companyCalculations;
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public int interact() {
        System.out.println("Calculated: " + companyCalculations.calc());
        int calculated = companyCalculations.calc();
        dataAccessInterface.saveCalcResult(calculated);
        OutputData od = new OutputData(calculated);
        outputBoundary.interact(od);
        return calculated;
    }
}
