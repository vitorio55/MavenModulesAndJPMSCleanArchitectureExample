package com.vitorio.businessentitymodule;

public record FirstCompanyCalculations(int val0, int val1) implements CompanyCalculations {

    @Override
    public int calc() {
        return val0 * val1;
    }
}
