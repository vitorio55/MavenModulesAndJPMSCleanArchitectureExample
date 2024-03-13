module com.vitorio.frameworkmodule {
    exports com.vitorio.frameworkmodule.controller to spring.beans, spring.web;
    opens com.vitorio.frameworkmodule to spring.core, spring.beans, spring.context;

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
    requires com.vitorio.dataprovidersqlmodule;
    requires com.vitorio.dataprovidernosqlmodule;
}