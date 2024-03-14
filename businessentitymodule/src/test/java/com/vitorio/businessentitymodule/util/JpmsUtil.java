package com.vitorio.businessentitymodule.util;

import java.io.File;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Paths;
import java.util.*;

public class JpmsUtil {

    private final ForbiddenModulesDefinitionProvider fmdp = new ForbiddenModulesDefinitionProvider();

    public Set<String> getApplicationsJpmsModules() {
        Set<String> applicationModules = new HashSet<>();
        File[] files = new File(Paths.get(System.getProperty("user.dir")).getParent().toAbsolutePath().toString()).listFiles();
        for (File f : files) {
            // Our application will always add 'module' suffix to our modules names
            if (!f.getName().contains("module")) {
                continue;
            }
            ModuleFinder finder = ModuleFinder.of(Paths.get(f.getPath() + "\\target\\classes"));
            Set<ModuleReference> moduleReferences = finder.findAll();
            Optional<ModuleReference> moduleOptional = moduleReferences.stream().findFirst();
            if (moduleOptional.isEmpty()) {
                continue;
            }
            String modName = moduleOptional.get().descriptor().name();
            if (!modName.contains("com.vitorio")) {
                continue;
            }
            applicationModules.add(modName);
        }
        return applicationModules;
    }

    public ModuleReference getCurrentJpmsModule() {
        var files = new File(Paths.get(System.getProperty("user.dir")).toAbsolutePath().toString())
            .listFiles();
        var targetOptional = Arrays.stream(files).filter(f -> f.getName().contains("target")).findFirst();
        if (targetOptional.isEmpty()) {
            return null;
        }
        ModuleFinder finder = ModuleFinder.of(Paths.get(targetOptional.get().getPath() + "\\classes"));
        Set<ModuleReference> moduleReferences = finder.findAll();
        Optional<ModuleReference> moduleOptional = moduleReferences.stream().findFirst();
        if (moduleOptional.isEmpty()) {
            return null;
        }
        return moduleOptional.get();
    }

    public List<String> getForbiddenInternalJPMSDependenciesForThisModule() {
        return fmdp.getForbiddenInternalJPMSDependenciesForThisModule();
    }

}
