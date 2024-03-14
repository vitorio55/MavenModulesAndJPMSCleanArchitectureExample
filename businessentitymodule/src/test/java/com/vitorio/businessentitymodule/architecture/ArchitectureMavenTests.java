package com.vitorio.businessentitymodule.architecture;

import com.vitorio.businessentitymodule.util.MavenModulesUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;

import static com.vitorio.businessentitymodule.util.MavenModulesUtil.DEPENDENCIES_ARTIFACT_ID_TAG_PATTERN;
import static org.junit.jupiter.api.Assertions.fail;

public class ArchitectureMavenTests {

    private final MavenModulesUtil mavenUtil = new MavenModulesUtil();

    @Test
    void should_not_include_any_internal_packages_in_pom_xml() throws IOException {
        String pomXmlContent = Files.readString(Paths.get("pom.xml"));
        Matcher matcher = DEPENDENCIES_ARTIFACT_ID_TAG_PATTERN.matcher(pomXmlContent);
        var internalModules = mavenUtil.getListOfInternalMavenModules();
        while (matcher.find()) {
            String artifactId = matcher.group(1);
            if (internalModules.contains(artifactId)) {
                fail("This layer must not include any other internal packages.");
            }
        }
    }

    @Test
    void should_not_include_forbidden_internal_packages_in_pom_xml() throws IOException {
        String pomXmlContent = Files.readString(Paths.get("pom.xml"));
        Matcher matcher = DEPENDENCIES_ARTIFACT_ID_TAG_PATTERN.matcher(pomXmlContent);
        List<String> forbiddenInternalPackages = mavenUtil.getForbiddenMavenInternalArtifactIdsForThisModule();
        while (matcher.find()) {
            String artifactId = matcher.group(1);
            if (forbiddenInternalPackages.contains(artifactId)) {
                fail("This layer must not include the following package as a dependency: [" + artifactId + "]");
            }
        }
    }
}
