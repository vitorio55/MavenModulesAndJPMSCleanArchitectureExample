package com.vitorio.businessentitymodule;

import com.vitorio.businessentitymodule.common.Company;

public class CompanyCalculationsFactory {

    public CompanyCalculations createCompanyCalculations(int val0, int val1, Company company) {
        return switch (company) {
            case FIRST -> new FirstCompanyCalculations(val0, val1);
            case SECOND -> new SecondCompanyCalculations(val0, val1);
        };
    }
}
