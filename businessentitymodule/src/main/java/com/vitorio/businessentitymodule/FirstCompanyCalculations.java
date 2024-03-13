package com.vitorio.businessentitymodule;

public class FirstCompanyCalculations implements CompanyCalculations {
    private int val0;
    private int val1;

    public FirstCompanyCalculations(int val0, int val1) {
        this.val0 = val0;
        this.val1 = val1;
    }

    @Override
    public int calc() {
        return val0 * val1;
    }
}
