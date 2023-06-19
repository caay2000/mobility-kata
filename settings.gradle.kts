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
    "libs:payment-sdk",
    "libs:payment-sdk-test"
)
