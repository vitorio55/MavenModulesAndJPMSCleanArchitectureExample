package com.vitorio.frameworkmodule.dto;

import com.vitorio.businessentitymodule.common.CompanyType;

public class CalculateCompanyDto {
    private int val0;
    private int val1;
    private CompanyType companyType;

    public int getVal0() {
        return val0;
    }

    public void setVal0(int val0) {
        this.val0 = val0;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }
}
