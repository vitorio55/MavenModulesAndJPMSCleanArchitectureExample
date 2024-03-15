package com.vitorio;

import com.vitorio.businessentitymodule.common.CompanyType;
import com.vitorio.dataprovidernosqlmodule.NoSqlDataProvider;
import com.vitorio.dataproviderrestmodule.ExternalRestClient;
import com.vitorio.usecasemodule.boundary.OutputBoundary;
import com.vitorio.usecasemodule.common.UseCase;
import com.vitorio.usecasemodule.data.InputData;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;
import com.vitorio.usecasemodule.boundary.UseCaseFactory;

public class Main {

    public static void main(String[] args) {
        //DataAccessInterface dai = new SqlDataProvider();
        DataAccessInterface dataAccessInterface = new NoSqlDataProvider();
        OutputBoundary externalRestClient = new ExternalRestClient();
        UseCaseFactory factory = new UseCaseFactory(dataAccessInterface, externalRestClient);
        InputData inputData = new InputData(3, 2, CompanyType.FIRST);
        int result = factory
            .createUseCase(UseCase.CALCULATE_COMPANY, inputData)
            .interact();
        System.out.println("In main, use case resulted in val: " + result);
    }
}
