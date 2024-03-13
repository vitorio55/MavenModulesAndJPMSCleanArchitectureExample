package com.vitorio.usecaseinteractormodule.data;

import com.vitorio.businessentitymodule.common.CompanyType;

public class InputData {
    private int val0;
    private int val1;
    private CompanyType companyType;

    public InputData(int val0, int val1, CompanyType companyType) {
        this.val0 = val0;
        this.val1 = val1;
        this.companyType = companyType;
    }

    public int getVal0() {
        return val0;
    }

    public int getVal1() {
        return val1;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }
}
