package com.vitorio;

import com.vitorio.businessentitymodule.common.CompanyType;
import com.vitorio.dataprovidernosqlmodule.NoSqlDataProvider;
import com.vitorio.dataproviderrestmodule.ExternalRestClient;
import com.vitorio.usecaseinteractormodule.boundary.OutputBoundary;
import com.vitorio.usecaseinteractormodule.common.UseCase;
import com.vitorio.usecaseinteractormodule.data.InputData;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;
import com.vitorio.usecaseinteractormodule.boundary.UseCaseInteractorFactory;

public class Main {

    public static void main(String[] args) {
        //DataAccessInterface dai = new SqlDataProvider();
        DataAccessInterface dataAccessInterface = new NoSqlDataProvider();
        OutputBoundary externalRestClient = new ExternalRestClient();
        UseCaseInteractorFactory factory = new UseCaseInteractorFactory(dataAccessInterface, externalRestClient);
        InputData inputData = new InputData(3, 2, CompanyType.FIRST);
        int result = factory
            .createUseCaseInteractor(UseCase.CALCULATE_COMPANY, inputData)
            .interact();
        System.out.println("In main, use case resulted in val: " + result);
    }
}
