plugins {
    id("mobility-kata-plugin-update-dependencies")
    id("org.jetbrains.kotlin.jvm")
    id("com.diffplug.spotless")
}

project.ext["kotlin_version"] = "1.8.21"
project.ext["ktor_version"] = "2.3.0"
project.ext["apache_commons_version"] = "1.10.0"
project.ext["junit_jupiter_version"] = "5.9.3"
project.ext["assertj_version"] = "3.24.2"
project.ext["microutils_logging_version"] = "3.0.5"
project.ext["logback_classic_version"] = "1.4.8"

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-reflect:${project.ext["kotlin_version"]}")

        implementation("io.ktor:ktor-server-core:${project.ext["ktor_version"]}")
        implementation("io.ktor:ktor-server-netty:${project.ext["ktor_version"]}")
        implementation("io.ktor:ktor-server-content-negotiation:${project.ext["ktor_version"]}")
        implementation("io.ktor:ktor-serialization-kotlinx-json:${project.ext["ktor_version"]}")
        implementation("io.ktor:ktor-server-call-logging:${project.ext["ktor_version"]}")

        implementation("io.github.microutils:kotlin-logging-jvm:${project.ext["microutils_logging_version"]}")
        implementation("ch.qos.logback:logback-classic:${project.ext["logback_classic_version"]}")

        implementation("org.junit.jupiter:junit-jupiter:${project.ext["junit_jupiter_version"]}")
        implementation("org.assertj:assertj-core:${project.ext["assertj_version"]}")
    }
}

testing {
    suites {
        @Suppress("UNUSED_VARIABLE")
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("${project.ext["junit_jupiter_version"]}")
        }
    }
}

spotless {
    kotlin { ktlint() }
    kotlinGradle { ktlint() }
}
