package com.vitorio.frameworkmodule.controller;

import com.vitorio.frameworkmodule.dto.CalculateCompanyDto;
import com.vitorio.usecasemodule.boundary.OutputBoundary;
import com.vitorio.usecasemodule.boundary.UseCaseFactory;
import com.vitorio.usecasemodule.common.UseCase;
import com.vitorio.usecasemodule.data.InputData;
import com.vitorio.usecasemodule.persistence.DataAccessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    private final UseCaseFactory factory;

    @Autowired
    public CompanyController(DataAccessInterface dataAccessInterface, OutputBoundary externalRestClient) {
        this.factory = new UseCaseFactory(dataAccessInterface, externalRestClient);
    }

    @PostMapping("/")
    public String calculateCompany(@RequestBody CalculateCompanyDto dto) {
        InputData inputData = new InputData(dto.getVal0(), dto.getVal1(), dto.getCompanyType());
        int result = factory
            .createUseCase(UseCase.CALCULATE_COMPANY, inputData)
            .interact();
        return "{ \"result\": " + result + "}";
    }
}
