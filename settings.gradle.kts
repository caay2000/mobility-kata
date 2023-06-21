pluginManagement {
    includeBuild("build-logic")
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "mobility-kata"
include(
    "app",
    "libs:dependency-injection",
    "libs:memory-database",
    "libs:payment-sdk:payment-client",
    "libs:payment-sdk:payment-client-test"
)
