plugins {
    id("mobility-kata-library")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("io.github.microutils:kotlin-logging-jvm")
    implementation("ch.qos.logback:logback-classic")

//    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core")
}
