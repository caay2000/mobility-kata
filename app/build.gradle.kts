plugins {
    id("mobility-kata-application")
    id("mobility-kata-plugin-kotlin-serialization")
}

dependencies {
    implementation(project(":libs:memory-database"))
    implementation(project(":libs:dependency-injection"))

    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-netty")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("io.ktor:ktor-server-call-logging")

    implementation("io.github.microutils:kotlin-logging-jvm")
}
