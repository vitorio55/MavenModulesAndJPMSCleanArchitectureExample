package com.vitorio.businessentitymodule.util;

import java.util.List;
import java.util.stream.Collectors;

public class ForbiddenModulesDefinitionProvider {

    public List<String> getForbiddenInternalJPMSDependenciesForThisModule() {
        return getForbiddenMavenInternalArtifactIdsForThisModule()
            .stream()
            .map(s -> "com.vitorio." + s)
            .collect(Collectors.toList());
    }

    public List<String> getForbiddenMavenInternalArtifactIdsForThisModule() {
        return List.of(
            "somemodule"
        );
    }
}
