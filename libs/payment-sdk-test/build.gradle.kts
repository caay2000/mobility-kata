plugins {
    id("mobility-kata-library")
}

dependencies {
    implementation(project(":libs:payment-sdk"))
    testImplementation("org.assertj:assertj-core")
}
