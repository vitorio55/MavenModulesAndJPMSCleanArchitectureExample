module com.vitorio.frameworkmodule {

    // TODO consider using flag --add-opens module/package=target-module(,target-module)* instead of adding things here

    exports com.vitorio.frameworkmodule.controller to spring.beans, spring.web;
    opens com.vitorio.frameworkmodule to spring.core, spring.beans, spring.context;

    exports com.vitorio.frameworkmodule.config to spring.beans, spring.context;
    opens com.vitorio.frameworkmodule.config to spring.core;

    exports com.vitorio.frameworkmodule.dto;

    // External dependencies
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.core;
    requires spring.context;
    requires spring.beans;

    // Dependencies within this project
    requires com.vitorio.entrypointmodule;
    requires com.vitorio.businessentitymodule;
    requires com.vitorio.usecaseinteractormodule;
    requires com.vitorio.entrypointsqsmodule;
    requires com.vitorio.dataprovidersqlmodule;
    requires com.vitorio.dataprovidernosqlmodule;
    requires com.vitorio.dataproviderrestmodule;
}