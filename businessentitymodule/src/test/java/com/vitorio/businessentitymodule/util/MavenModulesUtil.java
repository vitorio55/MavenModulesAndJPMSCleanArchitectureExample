package com.vitorio.businessentitymodule.util;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MavenModulesUtil {

    private final ForbiddenModulesDefinitionProvider fmdp = new ForbiddenModulesDefinitionProvider();

    public static final Pattern DEPENDENCIES_ARTIFACT_ID_TAG_PATTERN = Pattern.compile(
        "<dependency>\\s*<groupId>.*?</groupId>\\s*<artifactId>(.*?)</artifactId>\\s*<version>.*?</version>\\s*(<scope>.*?</scope>\\s*)?</dependency>\n",
        Pattern.CASE_INSENSITIVE
    );

    public Set<String> getListOfInternalMavenModules() {
        File[] files = new File(Paths.get(System.getProperty("user.dir")).getParent().toAbsolutePath().toString()).listFiles();
        return Arrays.stream(files).filter(f -> f.getName().contains("module"))
            .map(File::getName)
            .collect(Collectors.toSet());
    }

    public List<String> getForbiddenMavenInternalArtifactIdsForThisModule() {
        return fmdp.getForbiddenMavenInternalArtifactIdsForThisModule();
    }
}
