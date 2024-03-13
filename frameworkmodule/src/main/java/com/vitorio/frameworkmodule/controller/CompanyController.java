package com.vitorio.frameworkmodule.controller;

import com.vitorio.frameworkmodule.dto.CalculateCompanyDto;
import com.vitorio.usecaseinteractormodule.boundary.OutputBoundary;
import com.vitorio.usecaseinteractormodule.boundary.UseCaseInteractorFactory;
import com.vitorio.usecaseinteractormodule.common.UseCase;
import com.vitorio.usecaseinteractormodule.data.InputData;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    private final UseCaseInteractorFactory factory;

    @Autowired
    public CompanyController(DataAccessInterface dataAccessInterface, OutputBoundary externalRestClient) {
        this.factory = new UseCaseInteractorFactory(dataAccessInterface, externalRestClient);
    }

    @PostMapping("/")
    public String calculateCompany(@RequestBody CalculateCompanyDto dto) {
        InputData inputData = new InputData(dto.getVal0(), dto.getVal1(), dto.getCompanyType());
        int result = factory
            .createUseCaseInteractor(UseCase.CALCULATE_COMPANY, inputData)
            .interact();
        return "{ \"result\": " + result + "}";
    }
}
