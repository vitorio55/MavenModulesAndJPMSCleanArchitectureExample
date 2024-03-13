package com.vitorio.businessentitymodule;

public class SecondCompanyCalculations implements CompanyCalculations {
    private int val0;
    private int val1;

    public SecondCompanyCalculations(int val0, int val1) {
        this.val0 = val0;
        this.val1 = val1;
    }

    @Override
    public int calc() {
        return val0 + val1;
    }
}
