plugins {
    id("mobility-kata-library")
}

dependencies {
    testImplementation(project(":libs:payment-sdk:payment-client-test"))
    testImplementation("org.assertj:assertj-core")
}
