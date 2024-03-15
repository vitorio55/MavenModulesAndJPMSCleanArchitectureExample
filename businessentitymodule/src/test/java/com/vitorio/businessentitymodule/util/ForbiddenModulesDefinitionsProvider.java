package com.vitorio.businessentitymodule.util;

import java.util.Set;
import java.util.stream.Collectors;

class ForbiddenModulesDefinitionsProvider {

    private final Set<String> forbiddenModulesNames = BusinessEntityModuleArchDefinitions.getForbiddenModulesNames();

    public Set<String> getForbiddenInternalJPMSDependenciesForThisModule() {
        return getForbiddenMavenInternalArtifactIdsForThisModule()
            .stream()
            .map(s -> "com.vitorio." + s)
            .collect(Collectors.toSet());
    }

    public Set<String> getForbiddenMavenInternalArtifactIdsForThisModule() {
        return forbiddenModulesNames;
    }
}
