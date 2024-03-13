package com.vitorio.frameworkmodule.controller;

import com.vitorio.businessentitymodule.common.Company;
import com.vitorio.dataprovidernosqlmodule.NoSqlDataProvider;
import com.vitorio.entrypointmodule.MyRestController;
import com.vitorio.usecaseinteractormodule.boundary.UseCaseInteractorFactory;
import com.vitorio.usecaseinteractormodule.data.InputData;
import com.vitorio.usecaseinteractormodule.persistence.DataAccessInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {



    @GetMapping("/")
    public String someMethod(Integer val) {
        DataAccessInterface dai = new NoSqlDataProvider();
        UseCaseInteractorFactory useCaseInteractorFactory = new UseCaseInteractorFactory(dai);
        MyRestController rc = new MyRestController(useCaseInteractorFactory);
        InputData inputData = new InputData(3, 2, Company.FIRST);
        int result = rc.callEndpointCalculateCompany(inputData);
        System.out.println("In main, endpoint returned: " + result);
        return "home";
    }
}
