package com.vitorio.businessentitymodule.architecture;

import com.vitorio.businessentitymodule.util.JpmsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleReference;
import java.util.Set;

public class ArchitectureJpmsTests {

    private final JpmsUtil jpmsUtil = new JpmsUtil();

    @Test
    void should_not_include_forbidden_jpms_internal_modules() {
        String errMsg = "Forbidden module [%s] is being required in JPMS.";
        Set<String> jpmsModules = jpmsUtil.getApplicationsJpmsModules();
        ModuleReference mod = jpmsUtil.getCurrentJpmsModule();
        Set<ModuleDescriptor.Requires> requiredModules = mod.descriptor().requires();
        Set<String> forbiddenModules = jpmsUtil.getForbiddenInternalJPMSDependenciesForThisModule();
        for (ModuleDescriptor.Requires r : requiredModules) {
            Assertions.assertFalse(forbiddenModules.contains(r.name()), String.format(errMsg,  r.name()));
        }
    }
}
