plugins {
    id("mobility-kata-library")
}

dependencies {

    testImplementation(project(":libs:payment-sdk-test"))
    testImplementation("org.assertj:assertj-core")
}
